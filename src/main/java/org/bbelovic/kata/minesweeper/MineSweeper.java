package org.bbelovic.kata.minesweeper;

public class MineSweeper {
    public String process(MineField mineField) {
        char [] output = new char[mineField.size()];
        for (int i = 0; mineField.canMoveForward(); i++) {
            MineFieldPosition mineFieldPosition = mineField.moveForward();
            if (!mineFieldPosition.isMineField()) {
                long numberOfAdjacentMines = mineFieldPosition.getNumberOfAdjacentMines();
                output[i] = (char) ('0' + numberOfAdjacentMines);
            } else if (mineFieldPosition.isMineField()) {
                output[i] = '*';
            }
        }
        return new String(output);
    }

}
