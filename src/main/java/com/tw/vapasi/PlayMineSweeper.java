package com.tw.vapasi;

public class PlayMineSweeper {
    public static void main(String[] args) {
        //Game 1
        System.out.println("-----------------GAME STARTS------------------");
        String inputString0 = "m";
        MineFieldImpl mineField0 = new MineFieldImpl();
        mineField0.setMineField(inputString0);
        MineFieldIPrintImpl mineSweeperIPrint0 = new MineFieldIPrintImpl();

        Grid grid0 = new Grid(0, 0, State.OPEN.getActionChar());
        grid0.setDisplayChar(State.OPEN.getActionChar());
        mineField0.play(grid0);

        //Game 2
        System.out.println("-----------------GAME STARTS------------------");
        String inputString = "xx,xm";
        MineFieldImpl mineField = new MineFieldImpl();
        MineFieldIPrintImpl mineSweeperIPrint = new MineFieldIPrintImpl();
        mineField.setMineField(inputString);

        Grid grid1 = new Grid(0, 0, State.OPEN.getActionChar());
        grid1.setDisplayChar(State.OPEN.getActionChar());
        mineField.play(grid1);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
        Grid grid2 = new Grid(0, 1, State.OPEN.getActionChar());
        grid2.setDisplayChar(State.OPEN.getActionChar());
        mineField.play(grid2);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
        Grid grid3 = new Grid(1, 0, State.OPEN.getActionChar());
        grid3.setDisplayChar(State.OPEN.getActionChar());
        mineField.play(grid3);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
        Grid grid4 = new Grid(1, 1, State.FLAG.getActionChar());
        grid4.setDisplayChar(State.FLAG.getActionChar());
        mineField.play(grid4);
        mineSweeperIPrint.print(mineField);
        mineField.isGameOver();
    }
}
