package main;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {

    @Test
    public void shouldForwardToNextGeneration() {
        int[][] oscillationSeed = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}};
        Grid oscillationGrid = new GridBuilder().build(oscillationSeed);
        oscillationGrid.forwardToNextGeneration();
        Assert.assertTrue(oscillationGrid.hasLifeAt(0, 2));
        Assert.assertTrue(oscillationGrid.hasLifeAt(1, 2));
        Assert.assertTrue(oscillationGrid.hasLifeAt(2, 2));

        int[][] stillLifeSeed = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        Grid stillLifeGrid = new GridBuilder().build(stillLifeSeed);
        stillLifeGrid.forwardToNextGeneration();
        Assert.assertFalse(stillLifeGrid.hasLifeAt(0, 0));
        Assert.assertTrue(stillLifeGrid.hasLifeAt(1, 1));
        Assert.assertTrue(stillLifeGrid.hasLifeAt(1, 2));
        Assert.assertTrue(stillLifeGrid.hasLifeAt(2, 1));
        Assert.assertTrue(stillLifeGrid.hasLifeAt(2, 2));
        Assert.assertFalse(stillLifeGrid.hasLifeAt(3, 0));
    }
}
