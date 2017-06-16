package org.bbelovic.kata.minesweeper;

public class MineSweeper {
    public SweepedMineField process(MineField mineField) {
        final SweepedMineField result = new SweepedMineField();
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
