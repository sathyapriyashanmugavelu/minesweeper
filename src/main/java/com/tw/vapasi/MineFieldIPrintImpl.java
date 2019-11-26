package com.tw.vapasi;

import java.util.List;

public class MineFieldIPrintImpl implements IPrint {
    private List<Cell> cells;
    private int length;
    private MineFieldImpl mineFieldImpl;

    @Override
    public void print(MineFieldImpl mineFieldImpl) {
        int count = 0;
        cells = mineFieldImpl.getCells();
        length = mineFieldImpl.getDimension();
        for (Cell cell : cells) {
            System.out.print(cell.getState().getActionChar() + " ");
            count++;
            if (count % length == 0)
                System.out.println("\n");
        }
    }
}
