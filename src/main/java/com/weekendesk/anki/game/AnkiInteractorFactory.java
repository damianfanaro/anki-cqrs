package com.weekendesk.anki.game;

import com.weekendesk.anki.game.interactor.AnkiInteractiveTerminal;
import org.axonframework.commandhandling.gateway.CommandGateway;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
public class AnkiInteractorFactory {

    public static AnkiInteractor newAnkiInteractiveTerminal(CommandGateway commandGateway) {
        return new AnkiInteractiveTerminal(commandGateway);
    }

}
