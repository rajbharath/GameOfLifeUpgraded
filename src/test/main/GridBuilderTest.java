package main;

import org.junit.Assert;
import org.junit.Test;

public class GridBuilderTest {

    @Test
    public void shouldBuildGridForGivenSeed() {
        int[][] seed = {{1, 0}, {0, 1}};
        Grid grid = new GridBuilder().build(seed);
        Assert.assertTrue(grid.hasLifeAt(0, 0));
        Assert.assertFalse(grid.hasLifeAt(0, 1));
        Assert.assertFalse(grid.hasLifeAt(1, 0));
        Assert.assertTrue(grid.hasLifeAt(1, 1));
    }
}
