package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

public class StringParserCommand {
    private List<Cell> cells;
    private int dimension;

    public List<Cell> setMineField(String inputString) {
        cells = new ArrayList<Cell>();
        final String[] input = inputString.split(",");
        dimension = input.length;
        for (int i = 0; i < dimension; i++) {
            String stringInput = input[i];
            for (int j = 0; j < dimension; j++) {
                cells.add(new Cell(i, j, stringInput.charAt(j)));
            }
        }
        return cells;
    }
}
