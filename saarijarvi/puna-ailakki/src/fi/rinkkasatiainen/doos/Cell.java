package fi.rinkkasatiainen.doos;

public class Cell implements ICell {

    int aliveNeighbours;
    boolean isAlive;

    @Override
    public boolean isAlive() {

        if (this.getNeighbors() >= 2 && this.getNeighbors() <= 3) {
            isAlive = true;
            return true;
        }

        else if (this.getNeighbors() < 2 || this.getNeighbors() > 3) {
            isAlive = false;
            return false;
        }

        return false;
    }
    public boolean isRessurected() {

        if (!this.isAlive && this.getNeighbors() == 3)
            return true;

        return false;
    }

    public void setNeighbors(int n) {
        this.aliveNeighbours = n;
    }

    public int getNeighbors(){
        return aliveNeighbours;
    }
}
