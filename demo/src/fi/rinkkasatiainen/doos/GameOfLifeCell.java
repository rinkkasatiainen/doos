package fi.rinkkasatiainen.doos;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeCell implements Cell {
	
	private boolean isAlive;
	private int aliveNeighboursCount;
	private List<Cell> neighbourCells;
	

	public GameOfLifeCell(boolean alive) {
		neighbourCells = new ArrayList<Cell>();
		isAlive = alive;
		aliveNeighboursCount = 0;
	}
	
	public void addNeighbour(Cell neighbour) {
		neighbourCells.add(neighbour);
		if(neighbour.isAlive()) aliveNeighboursCount++;
	}

	@Override
	public boolean isAlive() {

		return isAlive;
	}

	@Override
	public void born() {
		isAlive = true;
	}

	@Override
	public void setAliveNeighboursCount(int i) {
		aliveNeighboursCount = i;
		
	}

	@Override
	public void die() {
		isAlive = false;
		notifyNeighboursAboutDeath();
	}

	private void notifyNeighboursAboutDeath() {
		for (int i = 0; i < neighbourCells.size(); i++) {
			neighbourCells.get(i).setANeighbourDead();
		}
	}

	/* (non-Javadoc)
	 * @see fi.rinkkasatiainen.doos.Cell#setANeighbourDead()
	 */
	@Override
	public void setANeighbourDead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshAliveStatus() {
		if((aliveNeighboursCount < 2) || (aliveNeighboursCount >3)) {
			die();
		}
		else if (aliveNeighboursCount == 2 || isAlive && aliveNeighboursCount == 3) {
			return;
		}
		else if (!isAlive && aliveNeighboursCount == 3) {
			born();
		}
	}

	@Override
	public int getAliveNeighboursCount() {
		return aliveNeighboursCount;
	}

}
