package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

class SweepedMineField {
    private final List<SweepedFieldPosition> deminedPositions = new ArrayList<>();
    String asText() {
        final StringBuilder sb = new StringBuilder();
        for (SweepedFieldPosition each: deminedPositions) {
            sb.append(each.getValue());
        }
        return sb.toString();
    }

    void addPosition(SweepedFieldPosition sweepedFieldPosition) {
       deminedPositions.add(sweepedFieldPosition);
    }
}
