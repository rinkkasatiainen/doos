package fi.rinkkasatiainen.doos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CellTest {

    @Test
    public void shouldBeAliveWhenBorn()  {
    	//arrange
    	Cell cell = new GameOfLifeCell(true);
    	//assert
    	assertThat(cell.isAlive(), equalTo(true));
    }
    
    @Test
    public void shouldNotBeAliveWhenKilled() {
    	Cell cell = new GameOfLifeCell(true);
    	cell.die();
    	assertThat(cell.isAlive(), equalTo(false));
    }
    
    @Test
    public void shouldDieIfLessThanTwoNeighbours() {
    	Cell cell = new GameOfLifeCell(true);
    	cell.setAliveNeighboursCount(1);
    	cell.refreshAliveStatus();
    	assertThat(cell.isAlive(), equalTo(false));
    	
    	
    }
    
    @Test
    public void shouldLiveWith3Neighbours() {
    	Cell cell = new GameOfLifeCell(true);
    	cell.setAliveNeighboursCount(3);
    	cell.refreshAliveStatus();
    	assertThat(cell.isAlive(), equalTo(true));
    }
    
    @Test
    public void shouldLiveWith2Neighbours() {
    	Cell cell = new GameOfLifeCell(true);
    	cell.setAliveNeighboursCount(2);
    	cell.refreshAliveStatus();
    	assertThat(cell.isAlive(), equalTo(true));
    }
    
    @Test
    public void shouldDieWithMoreThan3Neighbours() {
    	Cell cell = new GameOfLifeCell(true);
    	cell.setAliveNeighboursCount(4);
    	cell.refreshAliveStatus();
    	assertThat(cell.isAlive(), equalTo(false));
    }
    
    @Test
    public void shouldRessurectIf3AliveNeighbours() {
    	Cell cell = new GameOfLifeCell(false);
    	cell.setAliveNeighboursCount(3);
    	cell.refreshAliveStatus();
    	assertThat(cell.isAlive(), equalTo(true));
    }
    
    @Test
    public void shouldNotBecomeAliveIf2Neighbours() {
    	Cell cell = new GameOfLifeCell(false);
    	cell.setAliveNeighboursCount(2);
    	cell.refreshAliveStatus();
    	assertThat(cell.isAlive(), equalTo(false));
    }
    
    @Test
    public void shouldChangedNeighbourStateChangeNumberOfAliveNeighbours() {
    	Cell cell = new GameOfLifeCell(false);
    	cell.addNeighbour(new GameOfLifeCell(true));
    	assertThat(cell.getAliveNeighboursCount(), equalTo(1));
    }
    
    @Test
    public void shouldChangedAliveNeighboursCountSubstractIfNeighbourDies() {
    	Cell cell = new GameOfLifeCell(true);
    	Cell neighbour = new GameOfLifeCell(true);
    	cell.addNeighbour(neighbour);
    	neighbour.die();
    	assertThat(cell.getAliveNeighboursCount(), equalTo(0));
    }
  
    
    
}
