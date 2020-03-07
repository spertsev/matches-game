package ru.firm.main.service;

public class Notifications {

    public void showGameStarted () {
        System.out.println("The game is started!");
    }

    public void showUserTurn() {
        System.out.print("Your turn. Input a number of matches to take them out: ");
    }

    public void showNotIntegerInput() {
        System.out.println("You've typed a not integer value!");
    }

    public void showNotCorrectIntegerInput() {
        System.out.println("You've typed a wrong matches number! It must be 1, 2 or 3, and less or equal to the current amount of the left matches.");
    }

    public void showComputerIsMoving() {
        System.out.println("Computer is moving now...");
    }

    public void showCurrentStatus(int matchesAmount) {
        System.out.println(matchesAmount + " matches left");
    }

    public void showTheWinner(String winner) {
        System.out.println("Only one match left - game over! " + winner + " has won.");
    }

}
