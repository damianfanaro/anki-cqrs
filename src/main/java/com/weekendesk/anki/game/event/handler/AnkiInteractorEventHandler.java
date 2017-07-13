package com.weekendesk.anki.game.event.handler;

import com.weekendesk.anki.game.AnkiInteractor;
import com.weekendesk.anki.game.event.*;
import org.axonframework.eventhandling.EventHandler;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
public class AnkiInteractorEventHandler {

    private final AnkiInteractor interactor;

    public AnkiInteractorEventHandler(AnkiInteractor interactor) {
        this.interactor = interactor;
    }

    @EventHandler
    void handle(SessionOpenedEvent sessionOpenedEvent) {
        interactor.onEvent(sessionOpenedEvent);
    }

    @EventHandler
    void handle(SessionClosedEvent sessionClosedEvent) {
        interactor.onEvent(sessionClosedEvent);
    }

    @EventHandler
    void handle(GameWonEvent gameWonEvent) {
        interactor.onEvent(gameWonEvent);
    }

    @EventHandler
    void handle(QuestionShownEvent questionShownEvent) {
        interactor.onEvent(questionShownEvent);
    }

    @EventHandler
    void handle(AnswerShownEvent answerShownEvent) {
        interactor.onEvent(answerShownEvent);
    }

}
