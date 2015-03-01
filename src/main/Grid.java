package main;

public class Grid {

    private static final String NEWLINE = "\n";
    private Cell[][] cells;
    private int maxRow;
    private int maxColumn;

    public Grid(Cell[][] cells) {
        this.cells = cells;
        this.maxRow = cells.length;
        this.maxColumn = cells[0].length;
    }

    public void forwardToNextGeneration() {
        computeNextGenerationLives();
        forwardAllToNextGeneration();
    }

    private void computeNextGenerationLives() {
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                computeNextGenerationLifeAt(row, column);
            }
        }
    }

    private void forwardAllToNextGeneration() {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                cells[i][j].forwardToNextGeneration();
            }
        }
    }

    private void computeNextGenerationLifeAt(int row, int column) {
        int neighbourCount = getLiveNeighboursCountAt(row, column);
        boolean nextGenerationLifeStatus = PopulationManager.getNextGenerationLife(cells[row][column].hasLife(), neighbourCount);
        cells[row][column].setNextGenerationLife(nextGenerationLifeStatus);
    }

    private int getLiveNeighboursCountAt(int row, int column) {
        int minRowIndex = findMinRowIndex(row);
        int maxRowIndex = findMaxRowIndex(row);
        int minColumnIndex = findMinColumnIndex(column);
        int maxColumnIndex = findMaxColumnIndex(column);
        int liveNeighboursCount = 0;
        for (int i = minRowIndex; i <= maxRowIndex; i++) {
            for (int j = minColumnIndex; j <= maxColumnIndex; j++) {
                if (!(i == row && j == column) && cells[i][j].hasLife())
                    liveNeighboursCount++;
            }
        }

        return liveNeighboursCount;
    }

    private int findMinRowIndex(int row) {
        if (row <= 0) return 0;
        else if (row > 0 && row <= maxRow - 1) return row - 1;
        else return row - 1;
    }

    private int findMaxRowIndex(int row) {
        if (row >= 0 && row < maxRow - 1) return row + 1;
        return row;
    }

    private int findMinColumnIndex(int column) {
        if (column <= 0) return 0;
        else if (column > 0 && column <= maxColumn - 1) return column - 1;
        else return column - 1;
    }

    private int findMaxColumnIndex(int column) {
        if (column >= 0 && column < maxColumn - 1) return column + 1;
        return column;
    }

    @Override
    public String toString() {
        String displayString = "";
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                displayString += cells[i][j].toString();
            }
            displayString += NEWLINE;
        }
        return displayString;
    }

    /**
     * This method got introduced for testing purpose only.
     */
    public boolean hasLifeAt(int row, int column) {
        return cells[row][column].hasLife();
    }

}
