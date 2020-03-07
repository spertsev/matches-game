package ru.firm.main.service;

import java.util.Scanner;

public class GameControl {
    private int matchesLeft;
    private int matchesInLastUserMove;
    private String lastMover;
    private Scanner scanner;
    private ComputerLogic computerLogic;
    private Notifications notifications;

    GameControl() {
        this.matchesLeft = 20;
        this.scanner = new Scanner(System.in);
        this.computerLogic = new ComputerLogic();
        this.notifications = new Notifications();
    }

    private void userMove() {
        int typedValue;

        notifications.showUserTurn();

        while (!scanner.hasNextInt()) {
            notifications.showNotIntegerInput();
            notifications.showUserTurn();
            scanner.next();
        }
        typedValue = scanner.nextInt();

        if (typedValue < 1 || typedValue > 3 || typedValue > this.matchesLeft) {
            notifications.showNotCorrectIntegerInput();
            userMove();
        } else {
            this.lastMover = "User";
            this.matchesInLastUserMove = typedValue;
            this.matchesLeft = this.matchesLeft - typedValue;
        }
    }

    private void computerMove() {
        notifications.showComputerIsMoving();
        this.lastMover = "Computer";
        this.matchesLeft = this.matchesLeft - computerLogic.calculateMatchesCountForComputerMove(this.matchesLeft, this.matchesInLastUserMove);
    }

    private void gameStatusCheck() {
        notifications.showCurrentStatus(this.matchesLeft);
        if (this.matchesLeft == 1) {
            notifications.showTheWinner(this.lastMover);
        }
    }

    public void playGame() {
        notifications.showGameStarted();
        gameStatusCheck();

        while (this.matchesLeft > 1) {
            computerMove();
            gameStatusCheck();
            if (this.matchesLeft == 1) {
                break;
            }
            userMove();
            gameStatusCheck();
        }

    }

}
