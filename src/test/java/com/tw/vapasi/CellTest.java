package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {
    @Test
    public void ShouldIsMineBeTrueIfItIsMineField() {
        Cell cell = new Cell(0, 0, 'm');
        assertEquals(true, cell.getIsMine());
    }

    @Test
    public void ShouldIsMineBeFalseWhenItIsNotMineField() {
        Cell cell = new Cell(0, 0, 'x');
        assertEquals(false, cell.getIsMine());
    }

    @Test
    public void ShouldDisplayCharBeXWhenMineField() {
        Cell cell = new Cell(0, 0, 'm');
        assertEquals('X', cell.getState().getActionChar());
    }

    @Test
    public void ShouldDisplayCharBeXWhenNotMineField() {
        Cell cell = new Cell(0, 0, 'x');
        assertEquals('X', cell.getState().getActionChar());
    }
}
