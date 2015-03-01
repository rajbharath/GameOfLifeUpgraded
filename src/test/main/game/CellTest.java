package main.game;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CellTest {

    @Rule
    public ExpectedException  expectedException = ExpectedException.none();

    @Test
    public void shouldThrowException() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Method invoked with out computing the status of next generation life");
        Cell cell = new Cell(true);
        cell.forwardToNextGeneration();
    }
}
