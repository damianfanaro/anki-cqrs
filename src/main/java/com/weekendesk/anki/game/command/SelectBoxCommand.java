package com.weekendesk.anki.game.command;

import com.weekendesk.anki.game.Box;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class SelectBoxCommand {

    @TargetAggregateIdentifier
    private final String id;

    private final Box box;

}
