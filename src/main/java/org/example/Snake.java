package org.example;

public class Snake extends BoardElement{

    public Snake(int start, int end) {
        super(start, end);
    }

    public int updatePosition(int position) {
        int updatedPosition = getEnd();
        System.out.printf("Bit by Snake,Going down from %s to %s\n", position, updatedPosition);
        return updatedPosition;
    }
}
