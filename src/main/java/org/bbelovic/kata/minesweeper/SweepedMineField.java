package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class SweepedMineField {
    private final List<String> deminedPositions = new ArrayList<>();
    public String asText() {
        final StringBuilder sb = new StringBuilder();
        for (String each: deminedPositions) {
            sb.append(each);
        }
        return sb.toString();
    }

    public void recordMinePosition() {
        deminedPositions.add("*");
    }

    public void recordSafePosition(long numberOfAdjacentMines) {
        deminedPositions.add(Long.toString(numberOfAdjacentMines));
    }
}
