package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MineFieldShould {

    @Test
    public void produce_swept_output() {
        MineField mineField = new MineField(".*.");
        SweepedMineField actual = mineField.sweep();
        assertEquals("1*1", actual.asText());
    }

    @Test
    public void
    tell_whether_one_can_move_forward_on_mine_field() {
        assertMoveOperationsOnFieldWithLength(0);
        assertMoveOperationsOnFieldWithLength(1);
        assertMoveOperationsOnFieldWithLength(4);
        assertMoveOperationsOnFieldWithLength(22);
    }

    @Test
    public void
    provide_details_about_current_field_position() {
        MineField mineField = new MineField(".*.");
        mineField.canMoveForward();
        MineFieldPosition position = mineField.moveForward();
        SweepedFieldPosition sweepedFieldPosition = position.toSweepedFieldPosition();
        assertEquals("1", sweepedFieldPosition.getValue());
        mineField.canMoveForward();
        position = mineField.moveForward();
        sweepedFieldPosition = position.toSweepedFieldPosition();
        assertEquals("*", sweepedFieldPosition.getValue());
        mineField.canMoveForward();
        position = mineField.moveForward();
        sweepedFieldPosition = position.toSweepedFieldPosition();
        assertEquals("1", sweepedFieldPosition.getValue());
    }

    private void assertMoveOperationsOnFieldWithLength(final int permittedMoves) {
        final MineField mineField = createMineFieldWithLength(permittedMoves);
        int counter = 0;
        while (mineField.canMoveForward()) {
            mineField.moveForward();
            counter++;
        }
        assertEquals(permittedMoves, counter);
        assertFalse(mineField.canMoveForward());
    }

    private MineField createMineFieldWithLength(int length) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < length; i++) {
            char fieldValue = random.nextBoolean() ? '.' : '*';
            sb.append(fieldValue);
        }
        return new MineField(sb.toString());
    }

}