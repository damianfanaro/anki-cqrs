package com.damianfanaro.anki.game.internal;

import com.damianfanaro.anki.card.Card;
import com.damianfanaro.anki.deck.Deck;
import com.damianfanaro.anki.deck.DeckLoader;
import com.damianfanaro.anki.deck.DeckStorage;
import com.damianfanaro.anki.game.AnkiGame;
import com.damianfanaro.anki.box.Box;

import java.util.Iterator;

/**
 * This class maintains the state of the game.
 * In addition, it provides convenient methods
 * to perform operations like: load/save decks,
 * check if the game is finished, etc.
 * <p>
 * It is agnostic of the way it will interact
 * with the user. Other classes will use this one by
 * a composition and provide specific details of the
 * interaction with the user (e.g. console, Web UI, etc).
 *
 * @author dfanaro
 */
public final class AnkiGameInternal implements AnkiGame {

    private final Deck initialDeck;
    private final DeckLoader deckLoader;
    private final DeckStorage deckStorage;
    private final Iterator<Card> initialDeckIterator;

    private Deck redDeck;
    private Deck orangeDeck;
    private Deck greenDeck;

    private Card currentCard;

    private boolean isNewGame;

    public AnkiGameInternal(Deck initialDeck, DeckLoader deckLoader, DeckStorage deckStorage) {
        this.initialDeck = initialDeck;
        this.initialDeckIterator = initialDeck.getCardsStream().iterator();
        this.deckLoader = deckLoader;
        this.deckStorage = deckStorage;
    }

    @Override
    public int getRedDeckSize() {
        return redDeck.size();
    }

    @Override
    public int getOrangeDeckSize() {
        return orangeDeck.size();
    }

    @Override
    public int getGreenDeckSize() {
        return greenDeck.size();
    }

    @Override
    public boolean gameWon() {
        return initialDeck.size() == greenDeck.size();
    }

    @Override
    public void openSession() {
        redDeck = deckLoader.loadRedDeck();
        orangeDeck = deckLoader.loadOrangeDeck();
        greenDeck = deckLoader.loadGreenDeck();
        isNewGame = redDeck.empty() && orangeDeck.empty() && greenDeck.empty();
    }

    @Override
    public void closeSession() {
        moveCards();
        deckStorage.saveRedDeck(redDeck);
        deckStorage.saveOrangeDeck(orangeDeck);
        deckStorage.saveGreenDeck(greenDeck);
    }

    @Override
    public String nextQuestionToStudy() {
        if (!gameWon()) {
            if (isNewGame) {
                if (initialDeckIterator.hasNext()) {
                    currentCard = initialDeckIterator.next();
                } else if (stillCardsToStudy()) {
                    redDeck.getCardsStream().findFirst().ifPresent(card -> currentCard = card);
                }
            } else if (stillCardsToStudy()) {
                redDeck.getCardsStream().findFirst().ifPresent(card -> currentCard = card);
            }
            return currentCard.getQuestion();
        } else {
            return "No questions to study";
        }
    }

    @Override
    public String answerForCurrentQuestion() {
        return currentCard.getAnswer();
    }

    @Override
    public void moveCurrentCard(Box box) {
        if (box == Box.RED) {
            redDeck.addCard(currentCard);
        } else if (box == Box.ORANGE) {
            orangeDeck.addCard(currentCard);
        } else {
            greenDeck.addCard(currentCard);
        }
    }

    private void moveCards() {
        orangeDeck.getCardsStream().forEach(redDeck::addCard);
        orangeDeck.clearCards();
        greenDeck.getCardsStream().forEach(orangeDeck::addCard);
        greenDeck.clearCards();
    }

    private boolean stillCardsToStudy() {
        return !redDeck.empty();
    }

}
