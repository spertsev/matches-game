package ru.firm.main.service;

public class ComputerLogic {

    public int calculateMatchesCountForComputerMove(int matchesLeft, int matchesInUserMove) {
        int matchesInComputerMove;

        if (matchesLeft == 20) {
            matchesInComputerMove = 3;
        } else {
            matchesInComputerMove = 4 - matchesInUserMove;
        }

        return matchesInComputerMove;
    }

}
