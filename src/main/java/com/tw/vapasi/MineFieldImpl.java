package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

public class MineFieldImpl implements MineField {
    private List<Cell> cells;
    private int dimension;
    private Cell cell;
    public State state;
    private int countOfCorrectGrids;

    public MineFieldImpl() {
    }

    public MineFieldImpl(Cell cell, State state) {
        this.cell = cell;
        this.state = state;
    }

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

    @Override
    public void play(Cell cell) {
        if (cell.getInputChar() == State.FLAG.getActionChar()) {
            flag(cell);
            return;
        }
        open(cell);
    }

    @Override
    public void flag(Cell cell) {
        Cell openedCell = cells.get(cell.getRow() * dimension + cell.getColumn());
        openedCell.setState(state.FLAG);

        if (openedCell.getIsMine()) {
            countOfCorrectGrids++;
        }
    }

    @Override
    public void open(Cell cell) {
        Cell openedCell = cells.get(cell.getRow() * dimension + cell.getColumn());
        if (openedCell.getIsMine()) {
            System.out.println(MineGridStatus.GAME_LOSS.status());
        }
        if (openedCell.getState() != State.OPEN) {
            openedCell.setState(state.OPEN);
            countOfCorrectGrids++;
        }
    }

    @Override
    public boolean isGameOver() {
        if (countOfCorrectGrids == noOfGrids()) {
            System.out.println(MineGridStatus.GAME_WIN.status());
            return true;
        }
        System.out.println(MineGridStatus.CONTINUE.status());
        return false;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getDimension() {
        return dimension;
    }

    private int noOfGrids() {
        return dimension * dimension;
    }
}
