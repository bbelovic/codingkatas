package org.bbelovic.kata.minesweeper;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MineFieldPreconditionsShould {
    @Test
    public void
    throw_exception_when_collection_mine_fields_is_null() {
        assertThrows(NullPointerException.class, () -> new MineField(2, 2, null));
    }

    @Test
    public void
    not_be_constructed_with_negative_row_count() {
        assertThrows(IllegalArgumentException.class, () -> new MineField(-1, 9, emptyList()));
    }

    @Test
    public void
    not_be_constructed_with_negative_column_count() {
        assertThrows(IllegalArgumentException.class, () -> new MineField(1, -9, emptyList()));
    }

    @Test
    public void
    throw_exception_when_number_of_minefield_positions_is_not_equal_to_product_of_row_and_columns() {
        assertThrows(IllegalArgumentException.class, () -> new MineField(2, 2, emptyList()));
    }
}
