package org.bbelovic.kata.minesweeper;

public class MineSweeper {
    public DeminedField process(MineField mineField) {
        final DeminedField result = new DeminedField();
        while (mineField.canMoveForward()) {
            MineFieldPosition mineFieldPosition = mineField.moveForward();
            if (!mineFieldPosition.isMineField()) {
                long numberOfAdjacentMines = mineFieldPosition.getNumberOfAdjacentMines();
                result.recordSafePosition(numberOfAdjacentMines);
            } else if (mineFieldPosition.isMineField()) {
                result.recordMinePosition();
            }
        }
        return result;
    }

}
