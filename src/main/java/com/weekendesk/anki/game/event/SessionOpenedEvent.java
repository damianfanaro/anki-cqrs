package com.weekendesk.anki.game.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * An Anki Session is an immutable
 * object that encapsulates a session
 * status for a specific moment
 * in time.
 *
 * @author dfanaro
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class SessionOpenedEvent {

    private final int redDeckSize;
    private final int orangeDeckSize;
    private final int greenDeckSize;
    private final boolean gameWon;

    public boolean newGame() {
        return getRedDeckSize() == 0 && getOrangeDeckSize() == 0 && getGreenDeckSize() == 0;
    }

}
