package main.game;

public class GameOfLife {
    private Grid grid;
    private int generationCount;

    public void start(int[][] seed, int generationCount) {
        grid = new GridBuilder().build(seed);
        this.generationCount = generationCount;
        display();
        evolve();
    }

    private void evolve() {
        for (int i = 0; i < generationCount; i++) {
            grid.forwardToNextGeneration();
            display();
        }
    }

    public void display(){
        System.out.println(grid.toString());
    }

}
