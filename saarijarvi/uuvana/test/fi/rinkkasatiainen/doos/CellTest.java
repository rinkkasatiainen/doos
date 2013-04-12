package fi.rinkkasatiainen.doos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CellTest {

	@Test
	public void shouldDieWhenLessThanTwoNeighbours() {
		//arrange
		Cell testCell = new Cell();
		
		//act
		testCell.die();
		
		//assert
		assertThat(testCell.isAlive(), equalTo(false));
	}
	
	@Test
	public void shouldDieWhenMoreThanThreeNeighbours() {
		//arrange
		Cell testCell = new Cell();
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		
		//act
		testCell.die();
		
		//assert
		assertThat(testCell.isAlive(), equalTo(false));
	}
	
	@Test
	public void shouldResurrectWhenThreeNeighbours() { 
		//arrange
		Cell testCell = new Cell();
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		
		//act
		testCell.resurrect();
		
		//assert
		assertThat(testCell.isAlive(), equalTo(true));
	}
	
	@Test
	public void shouldStayAliveWhenTwoNeighbours() {
		// arrange		
		Cell testCell = new Cell();
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		
		//act
			
		//assert
		assertThat(testCell.isAlive(), equalTo(true));
	}
	
	@Test
	public void shouldStayAliveWhenThreeNeighbours() {
		// arrange		
		Cell testCell = new Cell();
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		testCell.addNeighbour(new Cell());
		
		//act
			
		//assert
		assertThat(testCell.isAlive(), equalTo(true));
	}
}