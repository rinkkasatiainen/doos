package fi.rinkkasatiainen.doos;

public class BasicCell implements Cell {
    private boolean isAlive = false;
    private boolean nextIsAlive = false;

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setNextState(boolean alive) {
        nextIsAlive = alive;

    }

    @Override
    public void update() {
        isAlive = nextIsAlive;

    }

    public static void main(String[] args) {
        Grid grid = new EdgeGrid(4, 4);
        grid.setCellState(1, 1, true);
        grid.setCellState(1, 2, true);
        grid.setCellState(2, 2, true);
        System.out.println(grid);
        System.out.println("*****************************");
        grid.calculateNextState();
        grid.updateGrid();
        System.out.println(grid);

    }

}
