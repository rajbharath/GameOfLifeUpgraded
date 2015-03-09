package main.game;

import java.util.ArrayList;

public class Grid extends ArrayList<Row> {

    private static final String NEWLINE = "\n";
    private int maxRow;
    private int maxColumn;

    public Grid() {

    }

    public void forwardToNextGeneration() {
        this.maxRow = this.size();
        this.maxColumn = this.get(0).size();
        computeNextGenerationLives();
        forwardAllToNextGeneration();

    }

    private void computeNextGenerationLives() {
        for (Row row : this) {
            for (Cell cell : row) {
                computeNextGenerationLife(cell);
            }
        }
    }

    private void computeNextGenerationLife(Cell cell) {
        int neighbourCount = getLiveNeighboursCount(cell);
        boolean nextGenerationLifeStatus = PopulationManager.getNextGenerationLife(cell.hasLife(), neighbourCount);
        cell.setNextGenerationLife(nextGenerationLifeStatus);
    }

    private int getLiveNeighboursCount(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        System.out.println("row:" + row + " column:" + column);
        int minRowIndex = findMinRowIndex(row);
        int maxRowIndex = findMaxRowIndex(row);
        int minColumnIndex = findMinColumnIndex(column);
        int maxColumnIndex = findMaxColumnIndex(column);
        int liveNeighboursCount = 0;
        for (int i = minRowIndex; i <= maxRowIndex; i++) {
            for (int j = minColumnIndex; j <= maxColumnIndex; j++) {
                if (!(i == row && j == column) && getCellAt(i, j).hasLife())
                    liveNeighboursCount++;
            }
        }
        return 0;
    }

    private void forwardAllToNextGeneration() {
        for (Row row : this) {
            for (Cell cell : row) {
                cell.forwardToNextGeneration();
            }
        }
    }

    private int findMinRowIndex(int row) {
        if (row <= 0) return 0;
        else if (row > 0 && row <= getMaxRow() - 1) return row - 1;
        else return row - 1;
    }

    private int findMaxRowIndex(int row) {
        if (row >= 0 && row < getMaxRow() - 1) return row + 1;
        return row;
    }

    private int findMinColumnIndex(int column) {
        if (column <= 0) return 0;
        else if (column > 0 && column <= getMaxColumn() - 1) return column - 1;
        else return column - 1;
    }

    private int findMaxColumnIndex(int column) {
        if (column >= 0 && column < getMaxColumn() - 1) return column + 1;
        return column;
    }

    @Override
    public String toString() {
        String displayString = "";
        for (Row row : this) {
            for (Cell cell : row) {
                displayString += cell.toString();
            }
            displayString += NEWLINE;
        }
        return displayString;
    }

    /**
     * This method got introduced for testing purpose only.
     */
    public boolean hasLifeAt(int rowIndex, int columnIndex) {
        Cell cell = getCellAt(rowIndex, columnIndex);
        return cell.hasLife();
    }

    private Cell getCellAt(int rowIndex, int columnIndex) {
        Row row = get(rowIndex);
        Cell cell = row.get(columnIndex);
        return cell;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMaxColumn() {
        return maxColumn;
    }
}
