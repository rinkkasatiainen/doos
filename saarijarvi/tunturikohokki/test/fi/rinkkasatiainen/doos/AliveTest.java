package fi.rinkkasatiainen.doos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class AliveTest {
    @Test
    public void createLiveCell() throws Exception {
        Cell foo = new Cell(1, 1);
        foo.setLife(true);
        assertThat(foo.isAlive(), equalTo(true));
    }

    @Test
    public void grid() throws Exception {
        Grid world = new Grid(5, 5);
        world.setCellState(2, 3, true);
        assertThat(world.getCellState(2, 3), equalTo(true));
    }
}
