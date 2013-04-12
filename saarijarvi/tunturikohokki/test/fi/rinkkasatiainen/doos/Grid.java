package fi.rinkkasatiainen.doos;

public class Grid {
    Cell[][] world;

    public Grid(int width, int height) {
        // TODO Auto-generated constructor stub
        world = new Cell[width][height];
        for (int coordX = 0; coordX < width; coordX++) {
            for (int coordY = 0; coordY < height; coordY++) {
                world[coordX][coordY] = new Cell(coordX, coordY);
            }
        }

    }

    public Boolean getCellState(int coordX, int coordY) {
        // TODO Auto-generated method stub
        return world[coordX][coordY].isAlive();
    }

    public void setCellState(int coordX, int coordY, boolean life) {
        // TODO Auto-generated method stub
        world[coordX][coordY].setLife(life);
    }
}
