package org.bbelovic.kata.minesweeper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MineFieldLoader {
    public MineField load(Path path) {
        final StringBuilder sb = new StringBuilder();
        try (final InputStream is = Files.newInputStream(path)) {
            final byte [] arr = new byte[256];
            int readBytes;
            while ((readBytes = is.read(arr)) != -1) {
                sb.append(new String(Arrays.copyOf(arr, readBytes)));
            }

        } catch (final IOException e) {
            e.printStackTrace();
        }
        return parseFromString(sb.toString());
    }

    private MineField parseFromString(String input) {
        if (input.contains("\n")) {
            String[] split = input.split("\n");
            if (split.length > 1) {
                String[] dimensions = split[0].split(" ");
                int rows = Integer.parseInt(dimensions[0]);
                int cols = Integer.parseInt(dimensions[1]);
                List<Character> characters = new ArrayList<>();
                for (int i = 1; i < split.length; i++) {
                    char[] chars = split[i].toCharArray();
                    for (char each: chars) {
                        characters.add(each);
                    }
                }
                return new MineField(rows, cols, characters);
            } else {
                return new MineField(0, 0, Collections.emptyList());
            }
        }
        return new MineField(0, 0, Collections.emptyList());

    }
}
