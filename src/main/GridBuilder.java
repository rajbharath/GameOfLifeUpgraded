package main;

public class GridBuilder {

    public Grid build(int[][] seed) {
        Cell[][] cells = createCells(seed);
        return new Grid(cells);
    }

    private Cell[][] createCells(int[][] seed) {
        //TODO need to handle null seed or row in seed is null
        int row = seed.length;
        int column = seed[0].length;
        Cell[][] cells = new Cell[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (seed[i][j] == 1)
                    cells[i][j] = new Cell(i, j, true);
                else
                    cells[i][j] = new Cell(i, j, false);
            }
        }
        return cells;
    }


}
