package org.bbelovic.kata.minesweeper;

import org.junit.Test;

import static java.util.Collections.emptyList;

public class MineFieldPreconditionsShould {
    @Test(expected = NullPointerException.class)
    public void
    throw_exception_when_collection_mine_fields_is_null() {
        new MineField(2, 2, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void
    not_be_constructed_with_negative_row_count() {
        new MineField(-1, 9, emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void
    not_be_constructed_with_negative_column_count() {
        new MineField(1, -9, emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void
    throw_exception_when_number_of_minefield_positions_is_not_equal_to_product_of_row_and_columns() {
        new MineField(2, 2, emptyList());
    }
}
