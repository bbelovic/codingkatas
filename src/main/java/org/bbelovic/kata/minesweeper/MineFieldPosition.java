package org.bbelovic.kata.minesweeper;

public class MineFieldPosition {
    private static final char MINE_SYMBOL = '*';
    private final char fieldValue;
    private final long adjacentMines;

    public MineFieldPosition(char fieldValue, long adjacentMines) {
        this.fieldValue = fieldValue;
        this.adjacentMines = adjacentMines;
    }

    public boolean isMineField() {
        return fieldValue == MINE_SYMBOL;
    }

    public long getNumberOfAdjacentMines() {
        return adjacentMines;
    }
}
