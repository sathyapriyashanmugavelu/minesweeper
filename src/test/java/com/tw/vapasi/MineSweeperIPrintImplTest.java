package com.tw.vapasi;

import org.junit.jupiter.api.Test;

public class MineSweeperIPrintImplTest {
    @Test
    void shouldNotRevealMineFields() {
        String inputString0 = "xx,xm";
        MineFieldImpl mineField0 = new MineFieldImpl(inputString0);
        MineFieldIPrintImpl mineSweeperIPrint0 = new MineFieldIPrintImpl();
        mineSweeperIPrint0.print(mineField0);
    }

    @Test
    void shouldDisplay0ForOpenAndFForFlag() {
        String inputString = "xx,xm";
        MineFieldImpl mineField = new MineFieldImpl(inputString);
        MineFieldIPrintImpl mineSweeperIPrint = new MineFieldIPrintImpl();

        Cell cell1 = new Cell(0, 0, State.FLAG.getActionChar());
        mineField.play(cell1);
        mineSweeperIPrint.print(mineField);
        System.out.println("___________________");
        Cell cell2 = new Cell(0, 1, State.OPEN.getActionChar());
        mineField.play(cell2);
        mineSweeperIPrint.print(mineField);
        System.out.println("___________________");
        Cell cell3 = new Cell(1, 0, State.FLAG.getActionChar());
        mineField.play(cell3);
        mineSweeperIPrint.print(mineField);
        System.out.println("___________________");
    }
}
