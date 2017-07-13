package com.weekendesk.anki.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventhandling.AnnotationEventListenerAdapter;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
public final class AxonConfig {

    private static AxonConfig axonConfig;

    private final CommandGateway commandGateway;
    private final EventStore eventStore;
    private final CommandBus commandBus;
    private final Configurer configurer;

    private AxonConfig() {
        commandBus = new SimpleCommandBus();
        commandGateway = new DefaultCommandGateway(commandBus);
        eventStore = new EmbeddedEventStore(new InMemoryEventStorageEngine());
        configurer = DefaultConfigurer.defaultConfiguration();
        configurer.configureCommandBus(configuration -> commandBus);
        configurer.start();
    }

    public CommandGateway getCommandGateway() {
        return commandGateway;
    }

    public void subscribeEventStoreListener(final AnnotationEventListenerAdapter eventListenerAdapter) {
        eventStore.subscribe(eventMessages -> eventMessages.forEach(event -> {
                    try {
                        eventListenerAdapter.handle(event);
                    } catch (Exception e) {
                        throw new RuntimeException(e);

                    }
                }
        ));
    }

    public Configurer configurer() {
        return configurer;
    }

    public static AxonConfig instance() {
        if (axonConfig == null) {
            axonConfig = new AxonConfig();
        }
        return axonConfig;
    }

}
