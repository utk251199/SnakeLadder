package org.example;

public class Ladder extends BoardElement{

    public Ladder(int start, int end) {
        super(start, end);
    }

    public int updatePosition(int position) {
        int updatedPosition = getEnd();
        System.out.printf("Moving up with ladder from %s to %s\n", position, updatedPosition);
        return updatedPosition;
    }
}
