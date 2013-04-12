package fi.rinkkasatiainen.doos;

public class GameOfLifeBoard implements Board {

	private int aliveCells;
	private Cell[][] gameBoard;
	
	public GameOfLifeBoard() {
		aliveCells = 0;
		gameBoard = new Cell[6][6];
		for (int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = new GameOfLifeCell(false);
			}
		}
	}
	
	@Override
	public int getAliveCells() {
		return aliveCells;
	}

}
