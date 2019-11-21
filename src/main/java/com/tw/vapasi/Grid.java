package com.tw.vapasi;

public class Grid {
    private boolean isMine;
    private int row;
    private int column;
    private char displayChar;

    public Grid(int row, int column, char ch) {
        this.row=row;
        this.column=column;
        this.isMine = (ch == 'm');
    }

    public boolean getIsMine() {
        return this.isMine;
    }
}
