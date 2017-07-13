package com.weekendesk.anki.game.interactor;

import com.weekendesk.anki.game.AnkiInteractor;
import com.weekendesk.anki.box.Box;
import com.weekendesk.anki.game.command.*;
import com.weekendesk.anki.game.event.*;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.Scanner;

/**
 * Concrete implementation of {@link AnkiInteractor}
 * that interacts with the end user via a terminal.
 *
 * @author dfanaro
 */
public class AnkiInteractiveTerminal implements AnkiInteractor {

    private final CommandGateway commandGateway;
    private final Scanner scanner;

    public AnkiInteractiveTerminal(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        waitForEnterKeyPressed("Press ENTER to open previous session >");
        commandGateway.send(OpenSessionCommand.builder().build());
    }

    @Override
    public void onEvent(SessionOpenedEvent sessionOpenedEvent) {
        if (sessionOpenedEvent.newGame()) {
            System.out.println("No previous session found. Starting a new one.");
        } else if (sessionOpenedEvent.isGameWon()) {
            System.out.println("You already know all the questions.");
        } else {
            System.out.println("Session loaded:\n");
            System.out.println("\t" + sessionOpenedEvent.getRedDeckSize() + " card/s in the red box");
            System.out.println("\t" + sessionOpenedEvent.getOrangeDeckSize() + " card/s in the orange box");
            System.out.println("\t" + sessionOpenedEvent.getGreenDeckSize() + " card/s in the green box");
        }
        waitForEnterKeyPressed("Press ENTER to show the next question >");
        commandGateway.send(ShowQuestionCommand.builder().build());
    }

    @Override
    public void onEvent(SessionClosedEvent sessionClosedEvent) {
        System.out.println("\n---");
        System.out.println("This session has ended.");
        if (!sessionClosedEvent.isGameWon()) {
            System.out.println("\nThe next session will contain:");
            System.out.println("\t- " + sessionClosedEvent.getRedDeckSize() + " card/s in the red box");
            System.out.println("\t- " + sessionClosedEvent.getOrangeDeckSize() + " card/s in the orange box");
            System.out.println("\t- " + sessionClosedEvent.getGreenDeckSize() + " card/s in the green box");
        }
    }

    @Override
    public void onEvent(GameWonEvent gameWonEvent) {
        System.out.println("\n\n<<< CONGRATULATIONS! You have completed the study! >>>\n\n");
        waitForEnterKeyPressed("Press ENTER to end the study session >");
        commandGateway.send(CloseSessionCommand.builder().build());
    }

    @Override
    public void onEvent(QuestionShownEvent questionShownEvent) {
        System.out.println("\nQuestion: " + questionShownEvent + " [PRESS ENTER TO SEE THE ANSWER]");
        waitForEnterKeyPressed("Press ENTER to show the answer to this question >");
        commandGateway.send(ShowAnswerCommand.builder().build());
    }

    @Override
    public void onEvent(AnswerShownEvent answerShownEvent) {
        System.out.println("Answer: " + answerShownEvent + "\n");
        System.out.print("How good you did it ?  Select: 1 (not guessed), 2 (partially guessed) or 3 (guessed) > ");
        selectBox();
        waitForEnterKeyPressed("Press ENTER to show the next question >");
        commandGateway.send(ShowQuestionCommand.builder().build());
    }

    private void selectBox() {
        int userInput = scanner.nextInt();
        while (userInput != 1 && userInput != 2 && userInput != 3) {
            userInput = scanner.nextInt();
        }
        Box selectedBox;
        if (userInput == 1) {
            selectedBox = Box.RED;
        } else if (userInput == 2) {
            selectedBox = Box.ORANGE;
        } else {
            selectedBox = Box.GREEN;
        }
        commandGateway.send(SelectBoxCommand.builder().box(selectedBox).build());
    }

    private void waitForEnterKeyPressed(String message) {
        System.out.println(message);
        scanner.nextLine();
    }

}
