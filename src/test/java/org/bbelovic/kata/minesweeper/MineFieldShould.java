package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineFieldShould {

    @Test
    public void produce_swept_output() {
        String [][] testData = new String [][] {
                {"3 3\n...\n..*\n...", "011\n01*\n011"},
                {"4 4\n*...\n....\n.*..\n....", "*100\n2210\n1*10\n1110"},
                {"3 5\n**...\n.....\n.*...", "**100\n33200\n1*100"},
                {"1 4\n*...", "*100"},
                {"1 4\n.*..", "1*10"},
                {"1 4\n*.*.", "*2*1"},
                {"1 4\n....", "0000"},
                {"1 4\n****", "****"},
                {"1 1\n*", "*"},
                {"0 0\n", ""},
                {"2 2\n..\n..", "00\n00"}
        };        for (final String[] each: testData) {
            MineField mineField = new MineField(each[0]);
            SweptMineField actual = mineField.sweep();
            assertEquals("Failed to process: "+ each[0],each[1], actual.asText());
        }

    }
}