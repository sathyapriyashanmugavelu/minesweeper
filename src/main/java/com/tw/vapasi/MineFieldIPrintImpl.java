package com.tw.vapasi;

import java.util.List;

public class MineFieldIPrintImpl implements IPrint {
    private List<Grid> grids;
    private int length;
    private MineFieldImpl mineFieldImpl;

    @Override
    public void print(MineFieldImpl mineFieldImpl) {
        int count = 0;
        grids= mineFieldImpl.getGrids();
        length= mineFieldImpl.getDimension();
        for (Grid grid : grids) {
            System.out.print(grid.getDisplayChar() + " ");
            count++;
            if (count % length == 0)
                System.out.println("\n");
        }
    }
}
