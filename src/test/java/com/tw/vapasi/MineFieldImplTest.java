package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MineFieldImplTest {
    @Test
    public void shouldFlagWhenGridActionIsFlag() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Grid grid = new Grid(0, 0, State.FLAG.getActionChar());
        grid.setDisplayChar('F');
        minefield.play(grid);
        assertEquals('F', grid.getDisplayChar());
    }


    @Test
    public void shouldOpenWhenGridActionIsOpenAndNotMine() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Grid grid = new Grid(1, 0, State.OPEN.getActionChar());
        grid.setDisplayChar('0');
        minefield.play(grid);
        assertEquals('0', grid.getDisplayChar());
    }

    @Test
    public void shouldDisplayErrorMessageWhenOpenOnMine() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Grid grid = new Grid(1, 1, State.OPEN.getActionChar());
        boolean status = grid.getIsMine();
        assertEquals("Oops, you stepped on a mine! Game Over!", MineGridStatus.GAME_LOSS.status());
    }

    @Test
    public void shouldNotDisplayErrorMessageWhenOpenOnNotMine() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Grid grid = new Grid(1, 0, State.OPEN.getActionChar());
        boolean status = grid.getIsMine();
        assertEquals("Continue Playing", MineGridStatus.CONTINUE.status());
    }

    @Test
    public void shouldDisplayWinWhenAllGridsTraversedCorrectly() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Grid grid1 = new Grid(0, 0, State.OPEN.getActionChar());
        grid1.setDisplayChar(State.OPEN.getActionChar());
        minefield.play(grid1);
        Grid grid2 = new Grid(0, 1, State.OPEN.getActionChar());
        grid2.setDisplayChar(State.OPEN.getActionChar());
        minefield.play(grid2);
        Grid grid3 = new Grid(1, 0, State.OPEN.getActionChar());
        grid3.setDisplayChar(State.OPEN.getActionChar());
        minefield.play(grid3);
        Grid grid4 = new Grid(1, 1, State.FLAG.getActionChar());
        grid4.setDisplayChar(State.FLAG.getActionChar());
        minefield.play(grid4);
        assertEquals(true, minefield.isGameOver());
    }

    @Test
    public void shouldDisplayContinueWhenAllGridsNotTraversedCorrectly() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Grid grid1 = new Grid(0, 0, State.OPEN.getActionChar());
        minefield.play(grid1);
        Grid grid2 = new Grid(0, 1, State.OPEN.getActionChar());
        minefield.play(grid2);
        Grid grid3 = new Grid(1, 1, State.FLAG.getActionChar());
        minefield.play(grid3);
        assertEquals(false, minefield.isGameOver());
    }

    @Test
    public void shouldDisplayMineSweeperGrid() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        MineFieldIPrintImpl mineSweeperIPrint = new MineFieldIPrintImpl();
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Grid grid1 = new Grid(0, 0, State.OPEN.getActionChar());
        grid1.setDisplayChar(State.OPEN.getActionChar());
        minefield.play(grid1);
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Grid grid2 = new Grid(0, 1, State.OPEN.getActionChar());
        grid2.setDisplayChar(State.OPEN.getActionChar());
        minefield.play(grid2);
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Grid grid3 = new Grid(1, 1, State.FLAG.getActionChar());
        grid3.setDisplayChar(State.FLAG.getActionChar());
        minefield.play(grid3);
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Grid grid4 = new Grid(1, 0, State.OPEN.getActionChar());
        grid4.setDisplayChar(State.OPEN.getActionChar());
        minefield.play(grid4);
        mineSweeperIPrint.print(minefield);
        assertEquals(true, minefield.isGameOver());

    }
}
