package fi.rinkkasatiainen.doos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class TestFoo {

    /*
     * @Test public void shouldDoSomeSmartMagic() throws Exception { Cell
     * lookMa_I_canMock = mock(Cell.class);
     * 
     * when(lookMa_I_canMock.doStuff()).thenReturn(false);
     * 
     * assertThat(lookMa_I_canMock.doStuff(), equalTo(true)); }
     */
    @Test
    public void testCell() throws Exception {
        // arrange
        Cell cell1 = new BasicCell();
        Cell cell2 = new BasicCell();
        // act

        cell2.setNextState(true);
        cell2.update();

        // assert
        assertThat(cell1.isAlive(), equalTo(false));
        assertThat(cell2.isAlive(), equalTo(true));
    }

    @Test
    public void testGrid() throws Exception {
        Grid grid = new EdgeGrid(8, 8);
        grid.calculateNextState();
        grid.updateGrid();

        assertThat(grid.isCellAlive(1, 1), equalTo(false));
    }

}
