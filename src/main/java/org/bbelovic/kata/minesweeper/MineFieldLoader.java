package org.bbelovic.kata.minesweeper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.emptyList;

class MineFieldLoader {
    MineField load(final Path path) {
        final List<String> lines = readAllLines(path);
        return parseFromLines(lines);
    }

    private List<String> readAllLines(final Path path) {
        List<String> lines = emptyList();
        try {
            lines = Files.readAllLines(path);
        } catch (final IOException e) {
            System.err.println(format("Unable to read all lines from file [%s]", path));
            e.printStackTrace();
        }
        return lines;
    }

    private MineField parseFromLines(final List<String> fileLines) {
            int rows = 0;
            int cols = 0;
            List<Character> characters = emptyList();
            if (fileLines.size() > 1) {
                String[] dimensions = fileLines.get(0).split(" ");
                rows = Integer.parseInt(dimensions[0]);
                cols = Integer.parseInt(dimensions[1]);
                characters = new ArrayList<>();
                for (int i = 1; i < fileLines.size(); i++) {
                    char[] chars = fileLines.get(i).toCharArray();
                    for (char each: chars) {
                        characters.add(each);
                    }
                }
                return new MineField(rows, cols, characters);
            } else {
                return new MineField(rows, cols, characters);
            }
    }
}
