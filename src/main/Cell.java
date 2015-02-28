package main;

public class Cell {

    private int row;
    private int column;
    private boolean isAlive;

    public Cell(int row, int column) {
        this(row, column, false);
    }

    public Cell(int row, int column, boolean isAlive) {
        this.row = row;
        this.column = column;
        this.isAlive = isAlive;
    }

    public boolean hasLife() {
        return isAlive;
    }

}
