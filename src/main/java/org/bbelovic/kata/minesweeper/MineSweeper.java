package org.bbelovic.kata.minesweeper;

public class MineSweeper {
    public SweepedMineField process(MineField mineField) {
        final SweepedMineField result = new SweepedMineField();
        while (mineField.canMoveForward()) {
            MineFieldPosition mineFieldPosition = mineField.moveForward();
            SweepedFieldPosition sweepedFieldPosition = mineFieldPosition.toSweepedFieldPosition();
            result.addPosition(sweepedFieldPosition);
        }
        return result;
    }

}
