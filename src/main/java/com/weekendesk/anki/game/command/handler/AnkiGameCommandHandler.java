package com.weekendesk.anki.game.command.handler;

import com.weekendesk.anki.game.AnkiGame;
import com.weekendesk.anki.game.command.*;
import com.weekendesk.anki.game.event.*;
import org.axonframework.commandhandling.CommandHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * TODO: complete with description
 *
 * @author dfanaro
 */
public class AnkiGameCommandHandler {

    private final AnkiGame ankiGame;

    public AnkiGameCommandHandler(AnkiGame ankiGame) {
        this.ankiGame = ankiGame;
    }

    @CommandHandler(commandName = "openSessionCommand")
    public void onCommand(OpenSessionCommand command) {
        ankiGame.openSession();
        apply(SessionOpenedEvent.builder()
                .redDeckSize(ankiGame.getRedDeckSize())
                .orangeDeckSize(ankiGame.getOrangeDeckSize())
                .greenDeckSize(ankiGame.getGreenDeckSize())
                .gameWon(ankiGame.gameWon())
                .build());
    }

    @CommandHandler(commandName = "closeSessionCommand")
    public void onCommand(CloseSessionCommand command) {
        ankiGame.closeSession();
        apply(SessionClosedEvent.builder()
                .redDeckSize(ankiGame.getRedDeckSize())
                .orangeDeckSize(ankiGame.getOrangeDeckSize())
                .greenDeckSize(ankiGame.getGreenDeckSize())
                .gameWon(ankiGame.gameWon())
                .build());
    }

    @CommandHandler(commandName = "showQuestionCommand")
    public void onCommand(ShowQuestionCommand command) {
        String question = ankiGame.nextQuestionToStudy();
        apply(QuestionShownEvent.builder()
                .question(question)
                .build());
    }

    @CommandHandler(commandName = "showAnswerCommand")
    public void onCommand(ShowAnswerCommand command) {
        String answer = ankiGame.answerForCurrentQuestion();
        apply(AnswerShownEvent.builder()
                .answer(answer)
                .build());
    }

    @CommandHandler(commandName = "selectBoxCommand")
    public void onCommand(SelectBoxCommand command) {
        ankiGame.moveCurrentCard(command.getBox());
        apply(BoxSelectedEvent.builder().selectedBox(command.getBox()).build());
    }

}
