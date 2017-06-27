package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

class SweptMineField {
    private final List<String> deminedPositions = new ArrayList<>();
    private final int colCount;

    public SweptMineField(int colCount) {
        this.colCount = colCount;
    }

    String asText() {
        final StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (String each: deminedPositions) {
            sb.append(each);
            if (++counter == colCount) {
                sb.append("\n");
                counter = 0;
            }
        }
        return sb.toString().trim();
    }

    void addSweptValue(String sweptValue) {
       deminedPositions.add(sweptValue);
    }
}
