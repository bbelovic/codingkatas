package org.bbelovic.kata.minesweeper;

import java.nio.file.Paths;

public class MineSweeper {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Provide text file with input mine field as first program argument.");
        } else {
            final String inputFile = args[0];
            MineFieldLoader loader = new MineFieldLoader();
            MineField mineField = loader.load(Paths.get(inputFile));
            SweptMineField sweptMineField = mineField.sweep();
            System.out.println("Swept mine field");
            System.out.println(sweptMineField.asText());
        }
    }
}
