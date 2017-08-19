package com.damianfanaro.anki.game;

import com.damianfanaro.anki.game.event.*;
import org.axonframework.commandhandling.gateway.CommandGateway;

/**
 * This contract establish the standard way
 * an {@link AnkiGame} implementation will interact
 * with an concrete implementation of this interface.
 * <p>
 * Implementations of this interface could be:
 * - Java Swing
 * - Console
 * - Web Site
 *
 * @author dfanaro
 */
public interface AnkiInteractor {

    void play(CommandGateway commandGateway);

    void onEvent(SessionOpenedEvent sessionOpenedEvent);

    void onEvent(SessionClosedEvent sessionClosedEvent);

    void onEvent(GameWonEvent gameWonEvent);

    void onEvent(QuestionShownEvent questionShownEvent);

    void onEvent(AnswerShownEvent answerShownEvent);

}
