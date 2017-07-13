package com.weekendesk.anki.game.event;

import lombok.AccessLevel;
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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class SessionClosedEvent {

    private final int redDeckSize;
    private final int orangeDeckSize;
    private final int greenDeckSize;
    private final boolean gameWon;

}
