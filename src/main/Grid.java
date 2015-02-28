package main;

public class Grid {
    // builds the cell with the given seed.
    // return the cell if position given
    // move all the containing cells to next generation

    private Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

}
