package com.weekendesk.anki.game;

import com.weekendesk.anki.game.event.SessionOpenedEvent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link SessionOpenedEvent} class.
 *
 * @author dfanaro
 */
public class SessionOpenedEventTest {

    @Test
    public void testSessionIsInNewGameState() {
        SessionOpenedEvent sessionOpenedEvent = SessionOpenedEvent.builder().redDeckSize(0).orangeDeckSize(0).greenDeckSize(0).build();
        Assert.assertTrue(sessionOpenedEvent.newGame());
    }

    @Test
    public void testSessionIsNotInNewGameState() {
        SessionOpenedEvent sessionOpenedEvent = SessionOpenedEvent.builder().redDeckSize(3).orangeDeckSize(0).greenDeckSize(0).build();
        Assert.assertFalse(sessionOpenedEvent.newGame());
    }

    @Test
    public void tesGameWon() {
        SessionOpenedEvent sessionOpenedEvent = SessionOpenedEvent.builder().redDeckSize(0).orangeDeckSize(0).greenDeckSize(3).gameWon(true).build();
        Assert.assertTrue(sessionOpenedEvent.isGameWon());
    }

}
