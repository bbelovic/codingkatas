package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MineFieldShould {

    @Test
    public void produce_swept_output() {
        MineField mineField = new MineField(".*.");
        SweepedMineField actual = mineField.sweep();
        assertEquals("1*1", actual.asText());
    }
}