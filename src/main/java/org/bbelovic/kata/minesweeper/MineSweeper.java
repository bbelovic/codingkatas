package org.bbelovic.kata.minesweeper;

public class MineSweeper {
    public String process(MineField mineField) {
        char [] output = new char[mineField.size()];
        for (int i = 0; mineField.canMoveForward(); i++) {
            MineFieldPosition mineFieldPosition = mineField.moveForward();
            if (!mineFieldPosition.isMineField()) {
                int numberOfAdjacentMines = getNumberOfAdjacentMines(mineField, i);
                output[i] = (char) numberOfAdjacentMines;
            } else if (mineFieldPosition.isMineField()) {
                output[i] = '*';
            }
        }
        return new String(output);
    }

    private int getNumberOfAdjacentMines(MineField mineField, int i) {
        char zero = '0';
        int zeroAsInt = (int) zero;
        if (i-1 >= 0) {
            if (mineField.hasMineOnPosition(i-1)) {
                zeroAsInt++;
            }
        }
        if (i+1  < mineField.size()) {
            if (mineField.hasMineOnPosition(i+1)) {
                zeroAsInt++;
            }
        }
        return zeroAsInt;
    }
}
