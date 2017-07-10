package org.bbelovic.kata.minesweeper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

class MineFieldLoader {
    MineField load(final Path path) {
        final List<String> fileContent = readAllLines(path);
        return parseFromLines(fileContent);
    }

    private List<String> readAllLines(final Path path) {
        List<String> lines = emptyList();
        try {
            lines = Files.readAllLines(path);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private MineField parseFromLines(final List<String> fileLines) {
            if (fileLines.size() > 1) {
                String[] dimensions = fileLines.get(0).split(" ");
                int rows = Integer.parseInt(dimensions[0]);
                int cols = Integer.parseInt(dimensions[1]);
                List<Character> characters = new ArrayList<>();
                for (int i = 1; i < fileLines.size(); i++) {
                    char[] chars = fileLines.get(i).toCharArray();
                    for (char each: chars) {
                        characters.add(each);
                    }
                }
                return new MineField(rows, cols, characters);
            } else {
                return new MineField(0, 0, emptyList());
            }
    }
}
