package com.tw.vapasi;

public enum MineGridStatus {
    GAME_LOSS{
        @Override
        public String status(){
            return "Oops, you stepped on a mine! Game Over!";
        }
    },
    CONTINUE{
        @Override
        public String status(){
            return "Continue Playing";
        }
    }, GAME_WIN{
        @Override
        public String status(){
            return "Wow, you cleared the minefield ! Game Over !";
        }
    };

    public abstract String status();
}
