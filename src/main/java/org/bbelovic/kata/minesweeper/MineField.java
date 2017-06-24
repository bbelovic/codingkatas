package org.bbelovic.kata.minesweeper;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

final class MineField {

    private final char[] mines;
    private char [][] mines2d;
    private int position = -1;
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
                mines = split[1].toCharArray();
            } else {
                mines2d = new char[0][0];
                mines = "".toCharArray();
            }
        } else {
            mines = input.toCharArray();
        }
    }

    private boolean canMoveForwardCols() {
        return mines2d.length != 0 && (colsPosition + 1) <= mines2d[0].length - 1;
    }

    private boolean canMoveForwardRows() {
        return (rowsPosition + 1) <= mines2d.length - 1;
    }

    private boolean canMoveForward() {
        return canMoveForwardCols() || canMoveForwardRows();
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
        position = position + 1;
        final char fieldValue = mines2d[rowsPosition][colsPosition];
        final long adjacentMines = getNumberOfAdjacentMines();
        return new MineFieldPosition(fieldValue, adjacentMines);
    }

    private long getNumberOfAdjacentMines() {
        final int colCount = mines2d[0].length;
        final int rowCount = mines2d.length;
        Predicate<int[]> dimensions =
                (vector) -> vector[0] + colsPosition >= 0 && vector[0] + colsPosition < colCount &&
                            vector[1] + rowsPosition >= 0 && vector[1] + rowsPosition < rowCount;
        Function<int[], Character> neighbourMapper = (vector) ->
                mines2d[vector[1] + rowsPosition][ vector[0] + colsPosition];
        Predicate<Character> isMineField = (Character character) ->  character == '*';
        return moveVectors()
                .filter(dimensions)
                .map(neighbourMapper)
                .filter(isMineField)
                .count();
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

    private Stream<int[]> moveVectors() {
        return Stream.of(new int [] {1, 0}, new int [] {0, 1}, new int [] {1, 1},
                         new int [] {-1, 0}, new int [] {0, -1}, new int [] {-1, -1},
                         new int [] {-1, 1}, new int [] {1, -1}
        );
    }
}
