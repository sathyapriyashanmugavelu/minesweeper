package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void shouldOpenWhenGridActionIsOpenAndNotMine() {
        MineField minefield = new MineField("xx,xm");
        Grid grid=new Grid(1,0,'O');
        grid.setDisplayChar('O');
        minefield.flagCell(1,0,'O');
        assertEquals('O',grid.getDisplayChar());
    }
}
