package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineSweeperShould {

    @Test
    public void
    produce_output_with_number_of_mines_adjacent_to_each_safe_field() {
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
            SweepedMineField sweepedMineField = sweeper.process(mineField);
            assertEquals(eachRow[1], sweepedMineField.asText());
        }
    }
}
