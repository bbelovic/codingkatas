package org.bbelovic.kata.minesweeper;

public class MineField {

    private String mines;
    private int position = -1;

    public MineField(String s) {
        mines = s;
    }

    public char[] toCharArray() {
        return mines.toCharArray();
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

    public void moveForward() {
        position = position + 1;
    }
}
