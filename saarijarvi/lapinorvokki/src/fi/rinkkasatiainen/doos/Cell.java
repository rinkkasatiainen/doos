package fi.rinkkasatiainen.doos;

public interface Cell {

    boolean isAlive();

    // the state of cell during the next generation
    void setNextState(boolean alive);

    // update the current state to the next state
    void update();
}
