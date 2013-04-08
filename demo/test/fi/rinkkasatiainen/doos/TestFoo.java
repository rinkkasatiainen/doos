package fi.rinkkasatiainen.doos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFoo {

    @Test
    public void shouldDoSomeSmartMagic() throws Exception {
        Cell lookMa_I_canMock = mock(Cell.class);

        when(lookMa_I_canMock.doStuff()).thenReturn(false);

        assertThat(lookMa_I_canMock.doStuff(), equalTo(true));
    }

    @Test
    public void deadCellShouldBecomeAliveWhenItIsResurrected() throws Exception {
        //arrange
            Cell cell = new DeadCell();
        //act
            cell.resurrect();
        //assert
            assertThat(cell.isAlive(), equalTo(true));
    }
}
