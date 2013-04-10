package fi.rinkkasatiainen.doos;

public class EdgeGrid implements Grid {

    private int width;
    private int height;
    private Cell[][] grid;

    public EdgeGrid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[this.height][this.width];

        for (int yCoord = 0; yCoord < this.height; yCoord++) {
            for (int xCoord = 0; xCoord < this.width; xCoord++) {
                grid[yCoord][xCoord] = new BasicCell();
            }
        }

    }

    public void calculateNextState() {
        int neighbourCount = 0;
        Cell currCell;
        for (int yCoord = 0; yCoord < this.height; yCoord++) {
            for (int xCoord = 0; xCoord < this.width; xCoord++) {
                neighbourCount = 0;
                currCell = grid[yCoord][xCoord];

                for (int yNeighbour = yCoord - 1; yNeighbour <= yCoord + 1; yNeighbour++) {
                    for (int xNeighbour = xCoord - 1; xNeighbour <= xCoord + 1; xNeighbour++) {
                        if (!(yNeighbour == yCoord && xNeighbour == xCoord)) {
                            if (grid[(yNeighbour + height) % height][(xNeighbour + width)
                                    % width].isAlive()) {
                                neighbourCount++;
                            }
                        }
                    }
                }
                if (neighbourCount < 2 || neighbourCount > 3) {
                    currCell.setNextState(false);
                }
                if (neighbourCount == 3) {
                    currCell.setNextState(true);
                }
            }
        }
    }

    public void updateGrid() {
        for (int yCoord = 0; yCoord < this.height; yCoord++) {
            for (int xCoord = 0; xCoord < this.width; xCoord++) {
                grid[yCoord][xCoord].update();
            }
        }

    }

    public boolean isCellAlive(int xCoord, int yCoord) {
        return grid[yCoord][xCoord].isAlive();

    }

    @Override
    public String toString() {
        String returnString = "";
        for (int yCoord = 0; yCoord < this.height; yCoord++) {
            for (int xCoord = 0; xCoord < this.width; xCoord++) {
                if (grid[yCoord][xCoord].isAlive()) {
                    returnString += "X";
                } else {
                    returnString += "O";
                }
            }
            returnString += "\n";
        }
        return returnString;
    }

    @Override
    public void setCellState(int x, int y, boolean state) {
        grid[y][x].setNextState(state);
        grid[y][x].update();

    }

}
