package main;

import org.junit.Assert;
import org.junit.Test;

public class GridBuilderTest {

    @Test
    public void shouldBuildGridForGivenSeed() {
        int[][] seed = {{1, 0}, {0, 1}};
        Grid grid = new GridBuilder().build(seed);
        Assert.assertTrue(grid.getCell(0, 0).hasLife());
        Assert.assertFalse(grid.getCell(0, 1).hasLife());
        Assert.assertFalse(grid.getCell(1, 0).hasLife());
        Assert.assertTrue(grid.getCell(1, 1).hasLife());
    }

}
