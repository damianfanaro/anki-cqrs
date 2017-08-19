package com.damianfanaro.anki.game.command.handler;

import com.damianfanaro.anki.box.Box;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
public class AnkiGameCommandHandlerTest {

    private FixtureConfiguration<AnkiGameCommandHandler> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(AnkiGameCommandHandler.class);
    }

    @Test
    public void shouldProduceABoxSelectedEvent() {
        String id = UUID.randomUUID().toString();
        Box box = Box.GREEN;
//        fixture.given()
//                .when(SelectBoxCommand.builder().id(id).box(box).build())
//                .expectEvents(BoxSelectedEvent.builder().id(id).selectedBox(box).build());
    }

}
