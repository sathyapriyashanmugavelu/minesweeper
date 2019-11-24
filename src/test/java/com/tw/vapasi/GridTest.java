package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    @Test
    public void ShouldIsMineBeTrueIfItIsMineField() {
        Grid grid = new Grid(0, 0, 'm');
        assertEquals(true, grid.getIsMine());
    }

    @Test
    public void ShouldIsMineBeFalseWhenItIsNotMineField() {
        Grid grid = new Grid(0, 0, 'x');
        assertEquals(false, grid.getIsMine());
    }

    @Test
    public void ShouldDisplayCharBeXWhenMineField() {
        Grid grid = new Grid(0, 0, 'm');
        assertEquals('X', grid.getDisplayChar());
    }

    @Test
    public void ShouldDisplayCharBeXWhenNotMineField() {
        Grid grid = new Grid(0, 0, 'x');
        assertEquals('X', grid.getDisplayChar());
    }
}
