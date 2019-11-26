package com.tw.vapasi;

public class Cell {
    private boolean isMine;
    private int row;
    private int column;
    private char inputChar;
    private State state;

    public Cell() {
        this.setState(State.INITIAL);
    }

    public Cell(int row, int column,char ch) {
        this();
        this.row = row;
        this.column = column;
        this.inputChar = ch;
        this.isMine = (ch == 'm');
    }

    public char getInputChar() {
        return inputChar;
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean getIsMine() {
        return this.isMine;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
