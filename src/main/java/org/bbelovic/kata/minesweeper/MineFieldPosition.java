package org.bbelovic.kata.minesweeper;

public class MineFieldPosition {
    private static final char MINE_SYMBOL = '*';
    private final char fieldValue;
    private final long adjacentMines;

    public MineFieldPosition(char fieldValue, long adjacentMines) {
        this.fieldValue = fieldValue;
        this.adjacentMines = adjacentMines;
    }

    public SweptFieldPosition toSweepedFieldPosition() {
        if (fieldValue == MINE_SYMBOL) {
            return new SweptFieldPosition(String.valueOf(MINE_SYMBOL));
        }
        return new SweptFieldPosition(String.valueOf(adjacentMines));
    }
}
