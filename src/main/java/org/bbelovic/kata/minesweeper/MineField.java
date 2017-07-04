package org.bbelovic.kata.minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

final class MineField {

    private static final char MINE_SYMBOL = '*';
    private final char [][] mines2d;

    MineField(final int rows, final int cols, final List<Character> fields) {
        checkPreconditions(rows, cols, fields);
        mines2d = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mines2d[i][j] = fields.get(i*cols + j);
            }
        }
    }

    private void checkPreconditions(int rows, int cols, List<Character> fields) {
        requireNonNull(fields, "Collection of mine fields is required");
        if (rows < 0) {
            throw new IllegalArgumentException("Negative row count: "+ rows);
        }
        if (cols < 0) {
            throw new IllegalArgumentException("Negative column count: "+ cols);
        }
        if (rows * cols != fields.size()) {
            String message = format("Number of minefield positions [%d] differs from rows and columns product [%d]", fields.size(), rows * cols);
            throw new IllegalArgumentException(message);
        }
    }

    SweptMineField sweep() {
        int colCount = mines2d.length == 0 ? 0 : mines2d[0].length;
        final SweptMineField sweptMineField = new SweptMineField(colCount);
        for (int rowIndex = 0; rowIndex < mines2d.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < mines2d[rowIndex].length; columnIndex++) {
                sweptMineField.addSweptValue(getSweptValue(rowIndex, columnIndex));
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
                .filter(vector -> notApplicableCoordinates(vector, colsPosition, rowsPosition))
                .map(v -> getAdjacentFieldPositions(v, rowsPosition, colsPosition))
                .filter(this::minesOnly)
                .count();
    }

    private boolean notApplicableCoordinates(final int[] vector, int colsPosition, int rowsPosition) {
        final int colCount = mines2d[0].length;
        final int rowCount = mines2d.length;
        return vector[0] + colsPosition >= 0 && vector[0] + colsPosition < colCount &&
                vector[1] + rowsPosition >= 0 && vector[1] + rowsPosition < rowCount;
    }

    private char getAdjacentFieldPositions(int[] vector, int rowsPosition, int colsPosition) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MineField mineField = (MineField) o;
        return Arrays.deepEquals(mines2d, mineField.mines2d);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(mines2d);
    }
}
