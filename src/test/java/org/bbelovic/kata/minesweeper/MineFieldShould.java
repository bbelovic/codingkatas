package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MineFieldShould {

    @Test
    public void receive_minefield_dimensions_and_positions_via_constructor() {
        Object [][] testData = new Object [][] {
                {3, 3, ".....*...", "011\n01*\n011"},
                {4, 4, "*........*......", "*100\n2210\n1*10\n1110"},
                {3, 5, "**.........*...", "**100\n33200\n1*100"},
                {1, 4, "*...", "*100"},
                {1, 4, ".*..", "1*10"},
                {1, 4, "*.*.", "*2*1"},
                {1, 4, "....", "0000"},
                {1, 4, "****", "****"},
                {1, 1, "*", "*"},
                {0, 0, "", ""},
                {2, 2,"....", "00\n00"}
        };        for (final Object[] each: testData) {
            List<Character> fields = getMineFieldPositions(each[2]);
            MineField mineField = new MineField((Integer) each[0], (Integer) each[1], fields);
            SweptMineField actual = mineField.sweep();
            assertEquals("Failed to process: "+ each[0], each[3], actual.asText());
        }

    }

    private List<Character> getMineFieldPositions(Object each) {
        List<Character> fields = new ArrayList<>();
        char[] chars = ((String) each).toCharArray();
        for (char c: chars) {
            fields.add(c);
        }
        return fields;
    }
}