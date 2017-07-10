package org.bbelovic.kata.minesweeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MineFieldShould {

    private int rows;
    private int cols;
    private String mineFieldPositions;
    private String expectedOutput;

    public MineFieldShould(int rows, int cols, String mineFieldPositions, String expectedOutput) {
        this.rows = rows;
        this.cols = cols;
        this.mineFieldPositions = mineFieldPositions;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void
    produce_swept_output_for_correct_input() {
        final List<Character> fields = getMineFieldPositionsCollection(mineFieldPositions);
        final MineField mineField = new MineField(rows, cols, fields);
        final SweptMineField actual = mineField.sweep();
        assertEquals(expectedOutput, actual.asText());
    }

    @Parameters(name = "{index}: MineField({0}, {1}, {2}).sweep() == {3}")
    public static Object[][] testData() {
        return new Object [][] {
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
            };
    }

    private List<Character> getMineFieldPositionsCollection(Object each) {
        List<Character> fields = new ArrayList<>();
        char[] chars = ((String) each).toCharArray();
        for (char c: chars) {
            fields.add(c);
        }
        return fields;
    }
}