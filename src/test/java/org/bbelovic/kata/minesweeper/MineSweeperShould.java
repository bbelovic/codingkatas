package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineSweeperShould {

    @Test
    public void
    produce_swept_minefield_output_for_single_line_minefield_input() {
        String [][] testData = new String [][] {
                {"*...", "*100"},
                {".*..", "1*10"},
                {"*.*.", "*2*1"},
                {"....", "0000"},
                {"****", "****"},
                {"*", "*"},
                {"", ""}
        };
        MineSweeper sweeper = new MineSweeper();
        for (String [] eachRow: testData) {
            MineField mineField = new MineField(eachRow[0]);
            SweptMineField sweptMineField = sweeper.sweep(mineField);
            assertEquals(eachRow[1], sweptMineField.asText());
        }
    }
}
