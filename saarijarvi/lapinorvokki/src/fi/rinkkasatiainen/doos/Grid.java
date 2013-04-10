package fi.rinkkasatiainen.doos;

interface Grid {

    void updateGrid();

    boolean isCellAlive(int x, int y);

    void calculateNextState();

    void setCellState(int x, int y, boolean state);
}
