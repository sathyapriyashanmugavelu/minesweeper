package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    public void ShouldIsMineBeTrueIfMineField(){
        Grid grid=new Grid(0,0,'m');
        assertEquals(true,grid.getIsMine());
    }
}
