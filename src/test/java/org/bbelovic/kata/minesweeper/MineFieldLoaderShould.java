package org.bbelovic.kata.minesweeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MineFieldLoaderShould {

    private String filename;
    private MineField expectedMinefield;
    private final MineFieldLoader loader = new MineFieldLoader();

    public MineFieldLoaderShould(String filename, MineField expectedMinefield) {
        this.filename = filename;
        this.expectedMinefield = expectedMinefield;
    }

    @Parameters(name = "{index}: filename: {0}, expected minefield: {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][] {
                {"test22.txt",new MineField(2, 2, asList('.', '.', '.', '.'))},
                {"test00.txt",new MineField(0, 0, emptyList())},
                {"test11.txt",new MineField(1, 1, singletonList('.'))},
                {"test33.txt",new MineField(3, 3, asList('.','.','.','.','.','*','.','.','.'))},
                {"test14.txt",new MineField(1, 4, asList('.','.','.','.'))}
        });
    }

    @Test
    public void
    load_data_from_file_into_string() {
        Path path = getPathtoFile();
        MineField actual = loader.load(path);
        assertEquals(expectedMinefield, actual);
    }

    private Path getPathtoFile() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalStateException(format("Unable to create path for input file [%s]", filename));
        }
        return Paths.get(resource.getFile());
    }

}