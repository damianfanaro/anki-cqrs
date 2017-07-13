package com.weekendesk.anki;

import com.weekendesk.anki.config.AxonConfig;
import com.weekendesk.anki.game.AnkiGame;
import com.weekendesk.anki.game.AnkiGameFactory;
import com.weekendesk.anki.game.AnkiInteractor;
import com.weekendesk.anki.game.AnkiInteractorFactory;
import com.weekendesk.anki.game.command.handler.AnkiGameCommandHandler;
import com.weekendesk.anki.game.event.handler.AnkiInteractorEventHandler;
import com.weekendesk.anki.game.interactor.AnkiInteractiveTerminal;
import org.axonframework.eventhandling.AnnotationEventListenerAdapter;

/**
 * Starter Anki class. It contains the application's entry point.
 *
 * @author dfanaro
 */
public final class AnkiStarter {

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

        System.out.println("-------------------------------------------");
        System.out.println("******  WELCOME TO THE ANKI PROGRAM  ******");
        System.out.println("-------------------------------------------");

        startTheGame();

    }

    private static void startTheGame() {
        AnkiGame game = AnkiGameFactory.newAnkiGameImplDeckFromFileSystem();
        AnkiGameCommandHandler ankiGameCommandHandler = new AnkiGameCommandHandler(game);
        AxonConfig.instance().configurer().registerCommandHandler(c -> ankiGameCommandHandler);

        AnkiInteractor interactor = AnkiInteractorFactory.newAnkiInteractiveTerminal(AxonConfig.instance().getCommandGateway());
        AnkiInteractorEventHandler ankiInteractorEventHandler = new AnkiInteractorEventHandler(interactor);
        AxonConfig.instance().subscribeEventStoreListener(new AnnotationEventListenerAdapter(ankiInteractorEventHandler));

        interactor.play();
    }

}
