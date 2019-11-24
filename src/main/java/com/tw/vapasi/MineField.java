package com.tw.vapasi;

public interface MineField {
    void play(Grid grid);
    void flag(Grid grid);
    void open(Grid grid);
    boolean isGameOver();
}
