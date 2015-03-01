package main;

import main.game.GameOfLife;

public class Client {
    public static void main(String[] args){
        GameOfLife gameOfLife = new GameOfLife();
        int[][] oscillationSeed = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}};
        gameOfLife.start(oscillationSeed,4);
    }
}
