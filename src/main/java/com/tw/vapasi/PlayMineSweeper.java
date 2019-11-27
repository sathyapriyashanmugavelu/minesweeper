package com.tw.vapasi;

public class PlayMineSweeper {
    public static void main(String[] args) {
        //Game 1
        System.out.println("-----------------GAME STARTS------------------");
        String inputString0 = "m";
        MineFieldImpl mineField0 = new MineFieldImpl(inputString0);
        MineFieldIPrintImpl mineSweeperIPrint0 = new MineFieldIPrintImpl();

        Cell cell0 = new Cell(0, 0, State.OPEN.getActionChar());
        mineField0.play(cell0);

        //Game 2
        System.out.println("-----------------GAME STARTS------------------");
        String inputString = "xx,xm";
        MineFieldImpl mineField = new MineFieldImpl(inputString);
        MineFieldIPrintImpl mineSweeperIPrint = new MineFieldIPrintImpl();

        Cell cell1 = new Cell(0, 0, State.OPEN.getActionChar());
        mineField.play(cell1);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
        Cell cell2 = new Cell(0, 1, State.OPEN.getActionChar());
        mineField.play(cell2);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
        Cell cell3 = new Cell(1, 0, State.OPEN.getActionChar());
        mineField.play(cell3);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
        Cell cell4 = new Cell(1, 1, State.FLAG.getActionChar());
        mineField.play(cell4);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
    }
}
