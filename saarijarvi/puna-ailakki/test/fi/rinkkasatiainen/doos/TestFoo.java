package fi.rinkkasatiainen.doos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

public class TestFoo {

    @Test
    public void shouldCheckIfIsCellAlive() throws Exception {

        // arrange
        Cell cell = new Cell();
        cell.setNeighbors(3);

        // act
        cell.isAlive();

        // asset
        assertThat(cell.isAlive(), equalTo(true));
    }

    @Test
    public void shouldCheckIfCellIsDead() throws Exception {

        //arrange
        Cell cell = new Cell();
        cell.setNeighbors(1);

        //act
        cell.isAlive();

        //assert
        assertThat(cell.isAlive(), equalTo(false));
    }

    @Test
    public void shouldCheckIfCellIsResurrected() throws Exception {

        //arrange
        Cell cell = new Cell();
        cell.setNeighbors(3);

        //act
        cell.isRessurected();

        //assert
        assertThat(cell.isRessurected(), equalTo(true));
    }
}
