package fi.rinkkasatiainen.doos;

public class Cell {
	private boolean isAlive;

	private void resurrect() { isAlive = true; };
	private void die()  	 { isAlive = false; };

	public Cell(boolean isAliveParam)
	{
		isAlive = isAliveParam;
	}

	
	public boolean isAlive() {
		return isAlive;
	}

	
	public void setStatusAccordingToAliveNeighboursCount(int aliveNeighbours) {
		if (isAlive())
		{
			// cond 1 and 3
			if (aliveNeighbours < 2 || aliveNeighbours > 3)
				die();
			// else cond 2 applies and the cell continues living
		}
		else
		{
			// cond 4
			if (aliveNeighbours == 3)
				resurrect();
		}
	}

}
