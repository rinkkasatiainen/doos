package fi.rinkkasatiainen.doos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class BoardTest {

	  @Test
	  public void shouldNewBoardHaveNoAliveCells() {
	   	Board board = new GameOfLifeBoard();
	   	assertThat(board.getAliveCells(), equalTo(0));
	  }
}
