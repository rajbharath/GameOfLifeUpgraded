package main;

public class GameOfLife {
    private Grid grid;
    private int generationCount;

    public void start(int[][] seed, int generationCount) {
        grid = new GridBuilder().build(seed);
        this.generationCount = generationCount;
        evolve();
    }

    private void evolve() {
        for (int i = 0; i < generationCount; i++) {
            grid.forwardToNextGeneration();
        }
    }

    public String display(){
        return grid.toString();
    }

}
