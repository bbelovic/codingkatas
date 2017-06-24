package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineFieldShould {

    @Test
    public void produce_swept_output() {
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
        for (final String[] each: testData) {
            MineField mineField = new MineField(each[0]);
            SweptMineField actual = mineField.sweep();
            assertEquals("Failed to process: "+ each[0],each[1], actual.asText());
        }

    }
}