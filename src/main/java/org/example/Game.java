package org.example;

import java.util.Deque;

public class Game {

    Board board;
    Deque<Player> players;
    DiceStrategy dice;

    public Game(Board board, Deque<Player> players, DiceStrategy dice){
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    public void playGame() {

        while (true) {
            Player currentPlayer = players.removeFirst();
            System.out.printf("\nPlayer %s is at position %s\n", currentPlayer.getPlayerNumber(), currentPlayer.getCurrentPosition());
            int diceNumber = dice.rollDice();
            int newPosition = currentPlayer.getCurrentPosition() + diceNumber;

            if (newPosition > board.getSize() * board.getSize()) {
                System.out.printf("Player %s is the Winner", currentPlayer.getPlayerNumber());
                return;
            }

            int updatedPosition = checkForBoardElement(newPosition);
            currentPlayer.setCurrentPosition(updatedPosition);
            System.out.printf("After Dice roll,Player %s is at position %s\n", currentPlayer.getPlayerNumber(), currentPlayer.getCurrentPosition());
            players.addLast(currentPlayer);

        }
    }

    public int checkForBoardElement(int newPosition) {

        BoardElement boardElement = board.getCell(newPosition).getBoardElement();

        if (boardElement== null)
            return newPosition;

        return boardElement.updatePosition(newPosition);
    }
}
