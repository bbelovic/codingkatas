package org.bbelovic.kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class MineField {

    private final char[] mines;
    private int position = -1;

    public MineField(String s) {
        mines = s.toCharArray();
    }

    public int size() {
        return mines.length;
    }

    public boolean hasMineOnPosition(int position) {
        char c = mines[position];
        return c == '*';
    }

    public boolean canMoveForward() {
        return (position + 1) <= mines.length - 1;
    }

    public MineFieldPosition moveForward() {
        position = position + 1;
        final char fieldValue = mines[position];
        final List<Character> neighbours = new ArrayList<>();
        if (position - 1 >= 0) {
            neighbours.add(mines[position - 1]);
        }
        if (position + 1 < mines.length) {
            neighbours.add(mines[position + 1]);
        }
        return new MineFieldPosition(fieldValue, neighbours);
    }
}
