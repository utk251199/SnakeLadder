package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        Board board = new Board(10, 5, 5);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Deque<Player> players = new ArrayDeque<>();
        players.add(p1);
        players.add(p2);
        DiceStrategy dice = new StandardDice(1);
        Game game = new Game(board,players,dice);
        game.playGame();

    }
}