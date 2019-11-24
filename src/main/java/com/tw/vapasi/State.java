package com.tw.vapasi;

public enum State {
    FLAG('F'), OPEN('0'), INITIAL('X');
    private final char actionChar;

    State(char actionChar) {
        this.actionChar = actionChar;
    }

    public char getActionChar() {
        return actionChar;
    }
}
