package org.example;

import java.util.Random;

public class Board {

    private int size;
    private Cell[][] cells;
    private int snakesCount;
    private int ladderCount;

    Board(int size, int snakesCount, int ladderCount) {
        this.size = size;
        this.snakesCount = snakesCount;
        this.ladderCount = ladderCount;
        setupBoard(size, snakesCount, ladderCount);
    }


    void setupBoard(int size, int snakesCount, int ladderCount){

        Random rand = new Random();

        cells = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j] = new Cell();
            }
        }

        while(ladderCount>0){
            int ladderStart = rand.nextInt(size * size) + 1;
            int ladderEnd = rand.nextInt(size*size - ladderStart) + ladderStart + 1;
            int rowNumber = ladderStart/size;
            int colNumber = ladderStart%size;
            if(cells[rowNumber][colNumber].getBoardElement() != null){
                continue;
            }

            BoardElement ladder = new Ladder(ladderStart,ladderEnd);
            cells[rowNumber][colNumber].setBoardElement(ladder);
            ladderCount--;
        }

        while(snakesCount>0){
            int snakeStart = rand.nextInt(size * size) + 1;
            int snakeEnd = rand.nextInt(snakeStart -1 ) + 1;
            int rowNumber = snakeStart/size;
            int colNumber = snakeStart%size;
            if(cells[rowNumber][colNumber].getBoardElement() != null){
                continue;
            }

            BoardElement snake = new Snake(snakeStart,snakeEnd);
            cells[rowNumber][colNumber].setBoardElement(snake);
            snakesCount--;
        }
    }


    public int getSize() {
        return size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getLadderCount() {
        return ladderCount;
    }

    public int getSnakesCount() {
        return snakesCount;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void setLadderCount(int ladderCount) {
        this.ladderCount = ladderCount;
    }

    public void setSnakesCount(int snakesCount) {
        this.snakesCount = snakesCount;
    }
}
