package org.bbelovic.kata.minesweeper;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MineFieldLoaderShould {
    @Test
    public void
    load_data_from_file_into_string() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("test.txt");
        Path path = Paths.get(resource.getFile());
        MineFieldLoader loader = new MineFieldLoader();
        MineField actual = loader.load(path);
        MineField expected = new MineField(2, 2, Arrays.asList('.', '.', '.', '.'));
        Assert.assertEquals(expected, actual);
    }

}