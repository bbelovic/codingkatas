package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineSweeperShould {

    @Test
    public void
    produce_swept_minefield_output_for_multi_line_minefield_input() {
        String [][] testData = new String [][] {
                {"1 4\n*...", "*100"},
                {"1 4\n.*..", "1*10"},
                {"1 4\n*.*.", "*2*1"},
                {"1 4\n....", "0000"},
                {"1 4\n****", "****"},
                {"1 1\n*", "*"},
                {"0 0\n", ""},
                {"2 2\n..\n..", "00\n00"}
        };

        MineSweeper mineSweeper = new MineSweeper();
        for (final String[] each: testData) {
            SweptMineField actual = mineSweeper.sweep(new MineField(each[0]));
            assertEquals(each[1], actual.asText());
        }
    }
}
