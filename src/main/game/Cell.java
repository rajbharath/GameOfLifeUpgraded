package main.game;

public class Cell {

    private int row;
    private int column;
    private boolean isAlive;
    private boolean nextGenerationLife;
    private boolean isNextGenerationLifeComputed;

    public Cell(int row, int column, boolean isAlive) {
        this.row = row;
        this.column = column;
        this.isAlive = isAlive;
    }

    public boolean hasLife() {
        return isAlive;
    }

    public void setNextGenerationLife(boolean nextGenerationLife) {
        this.nextGenerationLife = nextGenerationLife;
        isNextGenerationLifeComputed = true;
    }

    public void forwardToNextGeneration() {

        if (!isNextGenerationLifeComputed)
            throw new IllegalStateException("Method invoked with out computing the status of next generation life");

        isAlive = nextGenerationLife;
        isNextGenerationLifeComputed = false;
    }

    @Override
    public String toString() {
        return isAlive ? "1 " : "0 ";
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
