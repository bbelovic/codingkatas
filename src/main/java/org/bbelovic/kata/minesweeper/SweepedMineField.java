package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

class SweptMineField {
    private final List<SweptFieldPosition> deminedPositions = new ArrayList<>();
    String asText() {
        final StringBuilder sb = new StringBuilder();
        for (SweptFieldPosition each: deminedPositions) {
            sb.append(each.getValue());
        }
        return sb.toString();
    }

    void addPosition(SweptFieldPosition sweptFieldPosition) {
       deminedPositions.add(sweptFieldPosition);
    }
}
