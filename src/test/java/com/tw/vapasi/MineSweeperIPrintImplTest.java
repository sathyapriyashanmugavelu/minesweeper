package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MineSweeperIPrintImplTest {

    @Test
    void shouldNotRevealMineFields() {
        String inputString0 = "xx,xm";
        MineFieldImpl mineField0 = new MineFieldImpl();
        mineField0.setMineField(inputString0);
        MineFieldIPrintImpl mineSweeperIPrint0 = new MineFieldIPrintImpl();
        mineSweeperIPrint0.print(mineField0);
    }

    @Test
    void shouldDisplay0ForOpenAndFForFlag() {
        String inputString = "xx,xm";
        MineFieldImpl mineField = new MineFieldImpl();
        MineFieldIPrintImpl mineSweeperIPrint = new MineFieldIPrintImpl();
        mineField.setMineField(inputString);

        Grid grid1 = new Grid(0, 0, State.FLAG.getActionChar());
        mineField.play(grid1);
        mineSweeperIPrint.print(mineField);
        System.out.println("___________________");
        Grid grid2 = new Grid(0, 1, State.OPEN.getActionChar());
        mineField.play(grid2);
        mineSweeperIPrint.print(mineField);
        System.out.println("___________________");
        Grid grid3 = new Grid(1, 0, State.FLAG.getActionChar());
        mineField.play(grid3);
        mineSweeperIPrint.print(mineField);
        System.out.println("___________________");
    }


}
