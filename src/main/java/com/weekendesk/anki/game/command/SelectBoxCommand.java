package com.weekendesk.anki.game.command;

import com.weekendesk.anki.box.Box;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@Getter
@Builder
@AllArgsConstructor
public final class SelectBoxCommand {

    private final Box box;

}
