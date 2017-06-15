package org.bbelovic.kata.minesweeper;

public class MineField {

    private String mines;
    private int position = -1;

    public MineField(String s) {
        mines = s;
    }

    public int size() {
        return mines.length();
    }

    public boolean hasMineOnPosition(int position) {
        char c = mines.charAt(position);
        return c == '*';
    }

    public boolean canMoveForward() {
        return (position + 1) <= mines.toCharArray().length - 1;
    }

    public MineFieldPosition moveForward() {
        position = position + 1;
        char fieldValue = mines.toCharArray()[position];
        return new MineFieldPosition(fieldValue);
    }
}
