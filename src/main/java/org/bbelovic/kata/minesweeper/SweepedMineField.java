package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class SweepedMineField {
    private final List<SweepedFieldPosition> deminedPositions = new ArrayList<>();
    public String asText() {
        final StringBuilder sb = new StringBuilder();
        for (SweepedFieldPosition each: deminedPositions) {
            sb.append(each.getValue());
        }
        return sb.toString();
    }

    public void addPosition(SweepedFieldPosition sweepedFieldPosition) {
       deminedPositions.add(sweepedFieldPosition);
    }
}
