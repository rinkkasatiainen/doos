/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rinkkasatiainen.doos;

/**
 *
 * @author StarSeeker
 */
class ConwayCell {

    private boolean alive = false;
    private boolean transitiveState;
    
    public ConwayCell() {
        
    }
    
    public boolean isAlive(){
        return alive;
    }
    
    public void setAlive(boolean state){
        alive = state;
    }

    void prepareSetAlive(boolean b) {
        transitiveState = b;
    }

    void executeStateChange() {
        alive = transitiveState;
    }
}
