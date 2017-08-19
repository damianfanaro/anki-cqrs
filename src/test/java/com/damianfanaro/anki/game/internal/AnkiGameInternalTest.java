package com.damianfanaro.anki.game.internal;

import com.damianfanaro.anki.card.Card;
import com.damianfanaro.anki.deck.Deck;
import com.damianfanaro.anki.deck.DeckFileWriter;
import com.damianfanaro.anki.deck.DeckStorage;
import org.junit.Before;

import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link AnkiGameInternal} class.
 *
 * @author dfanaro
 */
public class AnkiGameInternalTest {

    private Deck deck;
    private DeckStorage mockedDeckStorage;

    @Before
    public void setUp() {
        deck = new Deck();
        deck.addCard(Card.of("a", "1"));
        deck.addCard(Card.of("b", "2"));
        deck.addCard(Card.of("c", "3"));

        mockedDeckStorage = mock(DeckFileWriter.class);
        doNothing().when(mockedDeckStorage).saveRedDeck(any(Deck.class));
        doNothing().when(mockedDeckStorage).saveOrangeDeck(any(Deck.class));
        doNothing().when(mockedDeckStorage).saveGreenDeck(any(Deck.class));
    }

/*    @Test
    public void putAllCardsFromRedBoxToGreenBox() {

        // Given: a mocked Deck Loader
        DeckLoader mockedDeckLoader = mock(DeckLoader.class);
        when(mockedDeckLoader.loadRedDeck()).thenReturn(deck.getDeckCopy());
        when(mockedDeckLoader.loadOrangeDeck()).thenReturn(new Deck());
        when(mockedDeckLoader.loadGreenDeck()).thenReturn(new Deck());

        // Given: a mocked Anki Interactor
        AnkiInteractor mockedAnkiInteractor = mock(AnkiInteractor.class);
        doNothing().when(mockedAnkiInteractor).onEvent(anyString());
        doNothing().when(mockedAnkiInteractor).onEvent(anyString());
        doReturn(Box.GREEN).when(mockedAnkiInteractor).selectBox();

        // When: the game starts
        AnkiGame ankiGame = new AnkiGameInternal(deck, mockedDeckLoader, mockedDeckStorage);
        ankiGame.start(mockedAnkiInteractor);

        // Then:
        Assert.assertTrue(ankiGame.getRedDeckSize() == 0);
        Assert.assertTrue(ankiGame.getOrangeDeckSize() == 0);
        Assert.assertTrue(ankiGame.getGreenDeckSize() == deck.size());
        Assert.assertTrue(ankiGame.gameWon());

    }

    @Test
    public void putAllCardsFromInitialDeckToOrangeBox() {

        // Given: a mocked Deck Loader
        DeckLoader mockedDeckLoader = mock(DeckLoader.class);
        when(mockedDeckLoader.loadRedDeck()).thenReturn(new Deck());
        when(mockedDeckLoader.loadOrangeDeck()).thenReturn(new Deck());
        when(mockedDeckLoader.loadGreenDeck()).thenReturn(new Deck());

        // Given: a mocked Anki Interactor
        AnkiInteractor mockedAnkiInteractor = mock(AnkiInteractor.class);
        doNothing().when(mockedAnkiInteractor).onEvent(anyString());
        doNothing().when(mockedAnkiInteractor).onEvent(anyString());
        doReturn(Box.ORANGE).when(mockedAnkiInteractor).selectBox();

        // When: the game starts
        AnkiGame ankiGame = new AnkiGameInternal(deck, mockedDeckLoader, mockedDeckStorage);
        ankiGame.start(mockedAnkiInteractor);

        // Then:
        Assert.assertTrue(ankiGame.getRedDeckSize() == deck.size());
        Assert.assertTrue(ankiGame.getOrangeDeckSize() == 0);
        Assert.assertTrue(ankiGame.getGreenDeckSize() == 0);
        Assert.assertFalse(ankiGame.gameWon());

    }

    @Test
    public void doNothingBecauseAllCardsAreInGreenBox() {

        // Given: a mocked Deck Loader
        DeckLoader mockedDeckLoader = mock(DeckLoader.class);
        when(mockedDeckLoader.loadRedDeck()).thenReturn(new Deck());
        when(mockedDeckLoader.loadOrangeDeck()).thenReturn(new Deck());
        when(mockedDeckLoader.loadGreenDeck()).thenReturn(deck.getDeckCopy());

        // Given: a mocked Anki Interactor
        AnkiInteractor mockedAnkiInteractor = mock(AnkiInteractor.class);
        doNothing().when(mockedAnkiInteractor).onEvent(anyString());
        doNothing().when(mockedAnkiInteractor).onEvent(anyString());
        doReturn(Box.GREEN).when(mockedAnkiInteractor).selectBox();

        // When: the game starts
        AnkiGame ankiGame = new AnkiGameInternal(deck, mockedDeckLoader, mockedDeckStorage);
        ankiGame.start(mockedAnkiInteractor);

        // Then:
        Assert.assertTrue(ankiGame.getRedDeckSize() == 0);
        Assert.assertTrue(ankiGame.getOrangeDeckSize() == 0);
        Assert.assertTrue(ankiGame.getGreenDeckSize() == deck.size());
        Assert.assertTrue(ankiGame.gameWon());

    }*/

}
