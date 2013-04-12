package fi.rinkkasatiainen.doos;

public class Cell {
    int i;
    int j;

    boolean lives = false;

    public Cell(int i, int j) {
        // TODO Auto-generated constructor stub
        this.i = i;
        this.j = j;
        lives = false;
    }

    public Boolean isAlive() {
        // TODO Auto-generated method stub
        return lives;
    }

    public void setLife(boolean b) {
        // TODO Auto-generated method stub
        lives = b;
    }
}
