package org.bbelovic.kata.minesweeper;

import java.util.stream.Stream;

final class MineField {

    private char [][] mines2d;
    private int colsPosition = -1;
    private int rowsPosition = -1;

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
        for (int i = 0; i < mines2d.length; i++) {
            for (int j = 0; j < mines2d[i].length; j++) {
                char fieldValue = mines2d[i][j];
                rowsPosition = i;
                colsPosition = j;
                long adjacentMines = getNumberOfAdjacentMines();
                MineFieldPosition mineFieldPosition = new MineFieldPosition(fieldValue, adjacentMines);
                SweptFieldPosition sweptFieldPosition = mineFieldPosition.toSweepedFieldPosition();
                sweptMineField.addPosition(sweptFieldPosition);
            }
        }
        return sweptMineField;
    }

    private long getNumberOfAdjacentMines() {
        return adjacentPositionsCoordinates()
                .filter(this::incompatibleCoordinates)
                .map(this::toAdjacentPositions)
                .filter(this::minesOnly)
                .count();
    }

    private boolean incompatibleCoordinates(final int[] vector) {
        final int colCount = mines2d[0].length;
        final int rowCount = mines2d.length;
        return vector[0] + colsPosition >= 0 && vector[0] + colsPosition < colCount &&
                vector[1] + rowsPosition >= 0 && vector[1] + rowsPosition < rowCount;
    }

    private char toAdjacentPositions(int [] vector) {
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
