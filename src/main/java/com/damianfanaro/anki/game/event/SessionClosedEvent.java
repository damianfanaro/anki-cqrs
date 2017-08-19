package com.damianfanaro.anki.game.event;

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

    private int redDeckSize;
    private int orangeDeckSize;
    private int greenDeckSize;
    private boolean gameWon;

}
