package com.damianfanaro.anki.game;

import com.damianfanaro.anki.box.Box;

/**
 * Main contract for the Anki Game.
 * <p>
 * Implementations of this interface will
 * run the game and interact with a
 * {@link AnkiInteractor}.
 *
 * @author dfanaro
 */
public interface AnkiGame {

    boolean gameWon();

    int getRedDeckSize();

    int getOrangeDeckSize();

    int getGreenDeckSize();

    void openSession();

    void closeSession();

    void moveCurrentCard(Box box);

    String nextQuestionToStudy();

    String answerForCurrentQuestion();

}
