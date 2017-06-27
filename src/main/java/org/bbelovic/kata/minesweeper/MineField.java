package org.bbelovic.kata.minesweeper;

import java.util.stream.Stream;

final class MineField {

    private static final char MINE_SYMBOL = '*';
    private char [][] mines2d;

    MineField(final String input) {
        if (input.contains("\n")) {
            String[] split = input.split("\n");
            if (split.length > 1) {
                String[] dimensions = split[0].split(" ");
                int rows = Integer.parseInt(dimensions[0]);
                int cols = Integer.parseInt(dimensions[1]);
                mines2d = new char[rows][cols];
                for (int i = 1; i < split.length; i++) {
                    mines2d[i-1] = split[i].toCharArray();
                }
            } else {
                mines2d = new char[0][0];
            }
        }
    }

    SweptMineField sweep() {
        int colCount = mines2d.length == 0 ? 0 : mines2d[0].length;
        final SweptMineField sweptMineField = new SweptMineField(colCount);
        for (int rowIndex = 0; rowIndex < mines2d.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < mines2d[rowIndex].length; columnIndex++) {
                sweptMineField.addPosition(new SweptFieldPosition(getSweptValue(rowIndex, columnIndex)));
            }
        }
        return sweptMineField;
    }

    private String getSweptValue(final int rowIndex, final int columnIndex) {
        if (isSafeField(rowIndex, columnIndex)) {
            final long adjacentMines = getNumberOfAdjacentMines(columnIndex, rowIndex);
            return String.valueOf(adjacentMines);
        }
        return String.valueOf(mines2d[rowIndex][columnIndex]);
    }

    private boolean isSafeField(final int rowIndex, final int columnIndex) {
        return mines2d[rowIndex][columnIndex] != MINE_SYMBOL;
    }

    private long getNumberOfAdjacentMines(final int colsPosition, final int rowsPosition) {
        return adjacentPositionsCoordinates()
                .filter(vector -> incompatibleCoordinates(vector, colsPosition, rowsPosition))
                .map(v -> toAdjacentPositions(v, rowsPosition, colsPosition))
                .filter(this::minesOnly)
                .count();
    }

    private boolean incompatibleCoordinates(final int[] vector, int colsPosition, int rowsPosition) {
        final int colCount = mines2d[0].length;
        final int rowCount = mines2d.length;
        return vector[0] + colsPosition >= 0 && vector[0] + colsPosition < colCount &&
                vector[1] + rowsPosition >= 0 && vector[1] + rowsPosition < rowCount;
    }

    private char toAdjacentPositions(int[] vector, int rowsPosition, int colsPosition) {
        return mines2d[vector[1] + rowsPosition][ vector[0] + colsPosition];
    }

    private boolean minesOnly(final Character character) {
        return character == MINE_SYMBOL;
    }

    private Stream<int[]> adjacentPositionsCoordinates() {
        return Stream.of(new int [] {1, 0}, new int [] {0, 1}, new int [] {1, 1},
                         new int [] {-1, 0}, new int [] {0, -1}, new int [] {-1, -1},
                         new int [] {-1, 1}, new int [] {1, -1}
        );
    }
}
