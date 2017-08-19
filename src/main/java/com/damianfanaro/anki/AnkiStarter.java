package com.damianfanaro.anki;

import com.damianfanaro.anki.game.interactor.AnkiInteractiveTerminal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starter Anki class. It contains the application's entry point.
 *
 * @author dfanaro
 */
@SpringBootApplication
public class AnkiStarter {

    /**
     * Anki's entry point. It reads a deck from a file
     * and starts a new {@link AnkiInteractiveTerminal}.
     * <p>
     * It will retrieve the deck from a default file location unless
     * the following system property is set: <code>initial.deck.file.path</code>
     *
     * @param args of the program (no arguments required)
     */
    public static void main(String[] args) {

        SpringApplication.run(AnkiStarter.class, args);

    }

}
