package org.bbelovic.kata.minesweeper;

public class MineFieldPosition {
    private static final char MINE_SYMBOL = '*';
    private final char fieldValue;
    private final long adjacentMines;

    public MineFieldPosition(char fieldValue, long adjacentMines) {
        this.fieldValue = fieldValue;
        this.adjacentMines = adjacentMines;
    }

    public SweepedFieldPosition toSweepedFieldPosition() {
        if (fieldValue == MINE_SYMBOL) {
            return new SweepedFieldPosition(String.valueOf(MINE_SYMBOL));
        }
        return new SweepedFieldPosition(String.valueOf(adjacentMines));
    }
}
