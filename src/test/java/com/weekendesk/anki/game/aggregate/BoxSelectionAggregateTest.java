package com.weekendesk.anki.game.aggregate;

import com.weekendesk.anki.game.Box;
import com.weekendesk.anki.game.command.SelectBoxCommand;
import com.weekendesk.anki.game.event.BoxSelectedEvent;
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
public class BoxSelectionAggregateTest {

    private FixtureConfiguration<BoxSelectionAggregate> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(BoxSelectionAggregate.class);
    }

    @Test
    public void shouldProduceABoxSelectedEvent() {
        String id = UUID.randomUUID().toString();
        Box box = Box.GREEN;
        fixture.given()
                .when(SelectBoxCommand.builder().id(id).box(box).build())
                .expectEvents(BoxSelectedEvent.builder().id(id).selectedBox(box).build());
    }

}
