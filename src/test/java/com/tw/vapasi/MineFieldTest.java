package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MineFieldTest {
    @Test
    public void shouldFlagWhenGridActionIsFlag() {
        MineField minefield = new MineField("xx,xm");
        Grid grid=new Grid(0,0,'F');
        grid.setDisplayChar('F');
        minefield.flagCell(0,0,'F');
        assertEquals('F',grid.getDisplayChar());
    }

    @Test
    public void shouldOpenWhenGridActionIsOpenAndNotMine() throws SteppedOnMineException {
        MineField minefield = new MineField("xx,xm");
        Grid grid=new Grid(1,0,'O');
        grid.setDisplayChar('O');
        minefield.openCell(1,0,'O');
        assertEquals('O',grid.getDisplayChar());
    }

    @Test
    public void shouldThrowExceptionWhenOpenOnMine() throws SteppedOnMineException {
        MineField minefield = new MineField("xx,xm");
        assertThrows(SteppedOnMineException.class,()->minefield.openCell(1,1,'O'));
    }

    @Test
    public void shouldNotThrowExceptionWhenOpenOnNotMine() throws SteppedOnMineException {
        MineField minefield = new MineField("xx,xm");
        assertDoesNotThrow(()->minefield.openCell(1,0,'O'));
    }

    @Test
    public void shouldDisplayWinWhenAllGridsTraversedCorrectly() throws SteppedOnMineException {
        MineField minefield = new MineField("xx,xm");
        minefield.play(0,0,'O');
        minefield.play(0,1,'O');
        minefield.play(1,0,'O');
        assertEquals("Wow, you cleared the minefield ! Game Over !",minefield.play(1,1,'F'));
    }

    @Test
    public void shouldDisplayContinueWhenAllGridsNotTraversedCorrectly() throws SteppedOnMineException {
        MineField minefield = new MineField("xx,xm");
        minefield.play(0,0,'O');
        minefield.play(0,1,'O');
        assertEquals("Continue Playing",minefield.play(1,1,'F'));
    }

}
