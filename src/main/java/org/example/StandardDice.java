package org.example;

import java.util.Random;

public class StandardDice implements DiceStrategy{

    private final int diceCount;

    Random random = new Random();

    public StandardDice(int diceCount){
        this.diceCount = diceCount;
    }

    public int rollDice(){

        int total = 0;

        for(int i=0;i<diceCount;i++){
            total+= random.nextInt(6) + 1;
        }
        return total;
    }
}
