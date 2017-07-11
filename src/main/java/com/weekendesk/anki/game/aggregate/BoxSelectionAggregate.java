package com.weekendesk.anki.game.aggregate;

import com.weekendesk.anki.game.command.SelectBoxCommand;
import com.weekendesk.anki.game.event.BoxSelectedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@NoArgsConstructor
public class BoxSelectionAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public BoxSelectionAggregate(SelectBoxCommand selectBoxCommand) {
        apply(BoxSelectedEvent.builder()
                .id(selectBoxCommand.getId())
                .selectedBox(selectBoxCommand.getBox())
                .build());
    }

    @EventHandler
    public void onBoxSelectedEvent(BoxSelectedEvent boxSelectedEvent) {
        this.id = boxSelectedEvent.getId();
    }

}
