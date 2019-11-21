package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

public class MineField {
    private List<Grid> grid;
    private int length;

    public MineField(String inputString) {
        grid = new ArrayList<Grid>();
        final String[] input = inputString.split(",");
        length = input.length;
        for (int i = 0; i < length; i++) {
            String stringInput = input[i];
            for (int j = 0; j < length; j++) {
                grid.add(new Grid(i,j,stringInput.charAt(j)));
            }
        }
    }

    public String play(int row, int col, char action) throws SteppedOnMineException {
        if(action=='F'){
            flagGrid(row,col,action);
        }else {
            openGrid(row, col, action);
        }
        for (Grid mineGrid : grid) {
            if (!mineGrid.getIsMine() && mineGrid.getDisplayChar() != 'O')
                return MineGridStatus.CONTINUE.status();
        }
        return MineGridStatus.GAME_WIN.status();
    }

    public void flagGrid(int row, int col, char action){
        Grid openedCell = grid.get(row * length + col);
        openedCell.setDisplayChar(action);
    }

    public void openGrid(int row, int col, char action) throws SteppedOnMineException {
        Grid openedCell = grid.get(row * length + col);
        openedCell.setDisplayChar(action);
        if (openedCell.getIsMine() && openedCell.getDisplayChar() == 'O') {
            throw new SteppedOnMineException();
        }

    }

}
