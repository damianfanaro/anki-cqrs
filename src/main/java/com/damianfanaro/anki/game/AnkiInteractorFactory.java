package com.damianfanaro.anki.game;

import com.damianfanaro.anki.game.interactor.AnkiInteractiveTerminal;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
public class AnkiInteractorFactory {

    public static AnkiInteractor newAnkiInteractiveTerminal() {
        return new AnkiInteractiveTerminal();
    }

}
