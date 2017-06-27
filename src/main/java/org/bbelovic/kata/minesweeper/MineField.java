package org.bbelovic.kata.minesweeper;

import java.util.stream.Stream;

final class MineField {

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
                final char fieldValue = mines2d[rowIndex][columnIndex];
                final long adjacentMines = getNumberOfAdjacentMines(columnIndex, rowIndex);
                final MineFieldPosition mineFieldPosition = new MineFieldPosition(fieldValue, adjacentMines);
                final SweptFieldPosition sweptFieldPosition = mineFieldPosition.toSweepedFieldPosition();
                sweptMineField.addPosition(sweptFieldPosition);
            }
        }
        return sweptMineField;
    }

    private long getNumberOfAdjacentMines(final int colsPosition, final int rowsPosition) {
        return adjacentPositionsCoordinates()
                .filter(vector -> incompatibleCoordinates(vector, colsPosition, rowsPosition))
                .map(vector1 -> toAdjacentPositions(vector1, rowsPosition, colsPosition))
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

    private boolean minesOnly(Character character) {
        return character == '*';
    }

    private Stream<int[]> adjacentPositionsCoordinates() {
        return Stream.of(new int [] {1, 0}, new int [] {0, 1}, new int [] {1, 1},
                         new int [] {-1, 0}, new int [] {0, -1}, new int [] {-1, -1},
                         new int [] {-1, 1}, new int [] {1, -1}
        );
    }
}
