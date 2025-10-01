package org.example;

import java.util.Random;

public class Dice {

    private int diceCount;

    public Dice(int diceCount){
        this.diceCount = diceCount;
    }

    public int rollDice(){

        int total = 0;

        for(int i=0;i<diceCount;i++){
            total+= new Random().nextInt(6) + 1;
        }
        return total;
    }
}
