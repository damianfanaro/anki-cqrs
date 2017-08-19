package com.damianfanaro.anki.game;

import com.damianfanaro.anki.card.CardUtil;
import com.damianfanaro.anki.constant.AnkiConstants;
import com.damianfanaro.anki.deck.Deck;
import com.damianfanaro.anki.deck.DeckFileWriter;
import com.damianfanaro.anki.game.internal.AnkiGameInternal;
import com.damianfanaro.anki.deck.DeckFileReader;

/**
 * Convenient factory of different
 * implementations of the Anki game.
 *
 * @author dfanaro
 */
public final class AnkiGameFactory {

    public static AnkiGame newAnkiGameInternalDeckFromFileSystem() {
        DeckFileReader deckFileReader = new DeckFileReader();
        Deck deck = deckFileReader.read(AnkiConstants.DECK_PATH_SYSTEM_PROPERTY);
        deck.sortCards(CardUtil.ALPHABETIC_ORDER_BY_QUESTION);
        return new AnkiGameInternal(deck, new DeckFileReader(), new DeckFileWriter());
    }

}
