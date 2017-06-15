package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MineFieldShould {

    @Test
    public void
    provide_details_about_its_size() {
        int actualSize = new MineField("").size();
        assertEquals(0, actualSize);
        actualSize = new MineField("....").size();
        assertEquals(4, actualSize);
    }

    @Test
    public void
    tell_whether_there_is_a_mine_on_given_field_position() {
        MineField mineField = new MineField(".**..");
        assertFalse(mineField.hasMineOnPosition(0));
        assertTrue(mineField.hasMineOnPosition(1));
        assertTrue(mineField.hasMineOnPosition(2));
        assertFalse(mineField.hasMineOnPosition(3));
    }

    @Test
    public void
    tell_whether_one_can_move_forward_on_mine_field() {
        assertMoveOperationsOnFieldWithLength(0);
        assertMoveOperationsOnFieldWithLength(1);
        assertMoveOperationsOnFieldWithLength(4);
        assertMoveOperationsOnFieldWithLength(22);
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