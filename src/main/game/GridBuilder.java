package main.game;

public class GridBuilder {

    public Grid build(int[][] seed) {
        int maxRow = seed.length;
        int maxColumn = seed[0].length;
        Grid grid = new Grid();
        for (int currentRow = 0; currentRow < maxRow; currentRow++) {
            Row row = new Row();
            for (int currentColumn = 0; currentColumn < maxColumn; currentColumn++) {
                if (seed[currentRow][currentColumn] == 1)
                    row.add(new Cell(currentRow, currentColumn, true));
                else
                    row.add(new Cell(currentRow, currentColumn, false));
            }
            grid.add(row);
        }
        return grid;
    }

}
