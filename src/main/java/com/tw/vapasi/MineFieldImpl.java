package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

public class MineFieldImpl implements MineField{
    private List<Grid> grids;
    private int dimension;
    private Grid grid;
    public State state;
    private int countOfCorrectGrids ;

    public MineFieldImpl() {
    }

    public MineFieldImpl(Grid grid, State state) {
        this.grid = grid;
        this.state = state;
    }

    public List<Grid> setMineField(String inputString) {
        grids = new ArrayList<Grid>();
        final String[] input = inputString.split(",");
        dimension = input.length;
        for (int i = 0; i < dimension; i++) {
            String stringInput = input[i];
            for (int j = 0; j < dimension; j++) {
                grids.add(new Grid(i,j,stringInput.charAt(j)));
            }
        }
        return grids;
    }

    @Override
    public void play(Grid grid){
        if(grid.getDisplayChar() == State.FLAG.getActionChar()){
            flag(grid);
            return;
        }
        open(grid);
    }

    @Override
    public void flag(Grid grid){
        Grid openedCell = grids.get(grid.getRow() * dimension + grid.getColumn());
        openedCell.setDisplayChar(state.FLAG.getActionChar());

        if(openedCell.getIsMine()){
            countOfCorrectGrids++;
        }

    }

    @Override
    public void open(Grid grid) {
        Grid openedCell = grids.get(grid.getRow() * dimension + grid.getColumn());
        if(openedCell.getIsMine()){
            System.out.println(MineGridStatus.GAME_LOSS.status());
        }
        if(openedCell.getDisplayChar() != State.OPEN.getActionChar()) {
            openedCell.setDisplayChar(state.OPEN.getActionChar());
            countOfCorrectGrids++;
        }
    }

    @Override
    public boolean isGameOver() {
        if(countOfCorrectGrids == noOfGrids()) {
            System.out.println(MineGridStatus.GAME_WIN.status());
            return true;
        }
        System.out.println(MineGridStatus.CONTINUE.status());
        return false;
   }

    public List<Grid> getGrids() {
        return grids;
    }

    public int getDimension() {
        return dimension;
    }

    private int noOfGrids() {
        return dimension*dimension;
    }
}
