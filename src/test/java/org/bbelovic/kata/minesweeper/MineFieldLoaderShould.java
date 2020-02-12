package org.bbelovic.kata.minesweeper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MineFieldLoaderShould {

    private final MineFieldLoader loader = new MineFieldLoader();

    public static Object[][] testData() {
        return new Object[][] {
                {"test22.txt",new MineField(2, 2, asList('.', '.', '.', '.'))},
                {"test00.txt",new MineField(0, 0, emptyList())},
                {"test11.txt",new MineField(1, 1, singletonList('.'))},
                {"test33.txt",new MineField(3, 3, asList('.','.','.','.','.','*','.','.','.'))},
                {"test14.txt",new MineField(1, 4, asList('.','.','.','.'))}
        };
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void
    load_data_from_file_into_string(String filename, MineField expectedMinefield) {
        var path = getPathToFile(filename);
        var actualMinefield = loader.load(path);
        assertEquals(expectedMinefield, actualMinefield);
    }

    private Path getPathToFile(String filename) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalStateException(format("Unable to create path for input file [%s]", filename));
        }
        return Paths.get(resource.getFile());
    }
}