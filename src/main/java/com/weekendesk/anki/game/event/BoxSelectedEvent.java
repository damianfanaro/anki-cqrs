package com.weekendesk.anki.game.event;

import com.weekendesk.anki.game.Box;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoxSelectedEvent {

    private final String id;

    private final Box selectedBox;

}
