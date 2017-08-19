package com.damianfanaro.anki.config;

import com.damianfanaro.anki.game.AnkiGame;
import com.damianfanaro.anki.game.AnkiGameFactory;
import com.damianfanaro.anki.game.AnkiInteractor;
import com.damianfanaro.anki.game.AnkiInteractorFactory;
import com.damianfanaro.anki.game.command.handler.AnkiGameCommandHandler;
import com.damianfanaro.anki.game.event.handler.AnkiInteractorEventHandler;
import org.axonframework.commandhandling.AnnotationCommandHandlerAdapter;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@Configuration
@Profile("default")
public class AnkiConfig {

    @Bean
    public AnkiInteractor ankiInteractor() {
        return AnkiInteractorFactory.newAnkiInteractiveTerminal();
    }

    @Bean
    public AnkiInteractorEventHandler ankiInteractorEventHandler() {
        return new AnkiInteractorEventHandler(ankiInteractor());
    }

    @Bean
    public AnkiGame ankiGame() {
        return AnkiGameFactory.newAnkiGameInternalDeckFromFileSystem();
    }

    @Bean
    public CommandBus commandBus() {
        return new SimpleCommandBus();
    }

    @Bean
    public AnnotationCommandHandlerAdapter annotationCommandHandlerAdapter() {
        AnnotationCommandHandlerAdapter annotationCommandHandlerAdapter = new AnnotationCommandHandlerAdapter(new AnkiGameCommandHandler(ankiGame()));
        annotationCommandHandlerAdapter.subscribe(commandBus());
        return annotationCommandHandlerAdapter;
    }

}
