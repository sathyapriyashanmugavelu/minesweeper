package com.tw.vapasi;

public interface MineField {
    void play(Cell cell);

    void flag(Cell cell);

    void open(Cell cell);

    boolean isGameOver();
}
