package org.bbelovic.kata.minesweeper;

import java.util.List;

public class MineFieldPosition {
    private static final char MINE_SYMBOL = '*';
    private final char fieldValue;
    private final List<Character> neighbours;

    public MineFieldPosition(char fieldValue, List<Character> neighbours) {
        this.fieldValue = fieldValue;
        this.neighbours = neighbours;
    }

    public boolean isMineField() {
        return fieldValue == MINE_SYMBOL;
    }

    public long getNumberOfAdjacentMines() {
        if (isMineField()) {
            return 0;
        }
        return neighbours.stream()
                .filter(character -> character == MINE_SYMBOL)
                .count();
    }
}
