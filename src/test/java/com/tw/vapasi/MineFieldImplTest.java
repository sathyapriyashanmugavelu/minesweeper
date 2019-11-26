package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MineFieldImplTest {
    @Test
    public void shouldFlagWhenGridActionIsFlag() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Cell cell = new Cell(0, 0, State.FLAG.getActionChar());
        minefield.play(cell);
        assertEquals('F', cell.getInputChar());
    }

    @Test
    public void shouldOpenWhenGridActionIsOpenAndNotMine() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Cell cell = new Cell(1, 0, State.OPEN.getActionChar());
        minefield.play(cell);
        assertEquals('0', cell.getInputChar());
    }

    @Test
    public void shouldDisplayErrorMessageWhenOpenOnMine() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Cell cell = new Cell(1, 1, State.OPEN.getActionChar());
        boolean status = cell.getIsMine();
        assertEquals("Oops, you stepped on a mine! Game Over!", MineGridStatus.GAME_LOSS.status());
    }

    @Test
    public void shouldNotDisplayErrorMessageWhenOpenOnNotMine() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Cell cell = new Cell(1, 0, State.OPEN.getActionChar());
        boolean status = cell.getIsMine();
        assertEquals("Continue Playing", MineGridStatus.CONTINUE.status());
    }

    @Test
    public void shouldDisplayWinWhenAllGridsTraversedCorrectly() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Cell cell1 = new Cell(0, 0, State.OPEN.getActionChar());
        minefield.play(cell1);
        Cell cell2 = new Cell(0, 1, State.OPEN.getActionChar());
        minefield.play(cell2);
        Cell cell3 = new Cell(1, 0, State.OPEN.getActionChar());
        minefield.play(cell3);
        Cell cell4 = new Cell(1, 1, State.FLAG.getActionChar());
        minefield.play(cell4);
        assertEquals(true, minefield.isGameOver());
    }

    @Test
    public void shouldDisplayContinueWhenAllGridsNotTraversedCorrectly() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        Cell cell1 = new Cell(0, 0, State.OPEN.getActionChar());
        minefield.play(cell1);
        Cell cell2 = new Cell(0, 1, State.OPEN.getActionChar());
        minefield.play(cell2);
        Cell cell3 = new Cell(1, 1, State.FLAG.getActionChar());
        minefield.play(cell3);
        assertEquals(false, minefield.isGameOver());
    }

    @Test
    public void shouldDisplayMineSweeperGrid() {
        MineFieldImpl minefield = new MineFieldImpl();
        minefield.setMineField("xx,xm");
        MineFieldIPrintImpl mineSweeperIPrint = new MineFieldIPrintImpl();
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Cell cell1 = new Cell(0, 0, State.OPEN.getActionChar());
        minefield.play(cell1);
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Cell cell2 = new Cell(0, 1, State.OPEN.getActionChar());
        minefield.play(cell2);
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Cell cell3 = new Cell(1, 1, State.FLAG.getActionChar());
        minefield.play(cell3);
        mineSweeperIPrint.print(minefield);
        System.out.println("__________________________");
        Cell cell4 = new Cell(1, 0, State.OPEN.getActionChar());
        minefield.play(cell4);
        mineSweeperIPrint.print(minefield);
        assertEquals(true, minefield.isGameOver());
    }
}
