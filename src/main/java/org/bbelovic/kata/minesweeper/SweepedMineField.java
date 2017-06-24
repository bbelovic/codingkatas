package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

class SweptMineField {
    private final List<SweptFieldPosition> deminedPositions = new ArrayList<>();
    private final int colCount;

    public SweptMineField(int colCount) {
        this.colCount = colCount;
    }

    String asText() {
        final StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (SweptFieldPosition each: deminedPositions) {
            sb.append(each.getValue());
            if (++counter == colCount) {
                sb.append("\n");
                counter = 0;
            }
        }
        return sb.toString().trim();
    }

    void addPosition(SweptFieldPosition sweptFieldPosition) {
       deminedPositions.add(sweptFieldPosition);
    }
}
