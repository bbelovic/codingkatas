package org.bbelovic.kata.minesweeper;

public class MineFieldPosition {
    private final char fieldValue;

    public MineFieldPosition(char fieldValue) {
        this.fieldValue = fieldValue;
    }

    public boolean isMineField() {
        return fieldValue == '*';
    }
}
