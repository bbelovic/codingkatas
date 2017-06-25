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
        while (canMoveForward()) {
            MineFieldPosition mineFieldPosition = moveForward();
            SweptFieldPosition sweptFieldPosition = mineFieldPosition.toSweepedFieldPosition();
            sweptMineField.addPosition(sweptFieldPosition);
        }
        return sweptMineField;
    }

    private boolean canMoveForward() {
        return canMoveForwardCols() || canMoveForwardRows();
    }

    private boolean canMoveForwardCols() {
        return mines2d.length != 0 && (colsPosition + 1) <= mines2d[0].length - 1;
    }

    private boolean canMoveForwardRows() {
        return (rowsPosition + 1) <= mines2d.length - 1;
    }

    private MineFieldPosition moveForward() {
        if (rowsPosition == -1) {
            rowsPosition = rowsPosition + 1;
        }
        if (canMoveForwardCols()) {
            colsPosition = colsPosition + 1;
        } else if (canMoveForwardRows()) {
            rowsPosition = rowsPosition + 1;
            colsPosition = 0;
        }
        final char fieldValue = mines2d[rowsPosition][colsPosition];
        final long adjacentMines = getNumberOfAdjacentMines();
        return new MineFieldPosition(fieldValue, adjacentMines);
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
