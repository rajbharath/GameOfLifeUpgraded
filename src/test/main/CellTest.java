package main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;

public class CellTest {

    @Rule
    public ExpectedException  expectedException = ExpectedException.none();

    @Test
    public void shouldThrowException() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Method invoked with out computing the status of next generation life");
        Cell cell = new Cell(0,0,true);
        cell.forwardToNextGeneration();
    }
}
