/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rinkkasatiainen.doos;

/**
 *
 * @author StarSeeker
 */
class GameBoard {

    private ConwayCell[][] game;

    public GameBoard() {
        initializeBoard(3,3);
    }
    
    public GameBoard(int width, int height) {
        initializeBoard(width, height);
    }
    
    private void initializeBoard(int width, int height){
        game = new ConwayCell[width][height]; 
        for(int i=0; i<width; i++){
            for(int j = 0; j<height;j++){
                game[i][j] = new ConwayCell();
            }
        }
    }
    
    public int getWidth(){
        return game.length;
    }

    public int getHeight(){
        return game[0].length;
    }

    public void setCell(int x, int y, boolean state) {
        game[x][y].setAlive(state);
    }
    public boolean getCell(int x, int y) {
        if(x >= game.length || x < 0 ||
                y >= game[0].length || y < 0){
            return false;
        }else return game[x][y].isAlive();
    }

    public void update() {
        for(int i=0;i<game.length;i++){
            for(int j=0;j<game[i].length;j++){
                int aliveNeighbors = getAliveNeighbours(i, j);

                if (game[i][j].isAlive()) {
                    if(aliveNeighbors < 2 || aliveNeighbors > 3) {
                        game[i][j].prepareSetAlive(false);
                    } else {
                        game[i][j].prepareSetAlive(true);
                    }
                } else {
                    if(aliveNeighbors == 3) {
                        game[i][j].prepareSetAlive(true);
                    } else {
                        game[i][j].prepareSetAlive(false);
                    }
                }
            }
        }
        
        for(int i=0;i<game.length;i++){
            for(int j=0;j<game[i].length;j++){
                game[i][j].executeStateChange();
            }
        }
    }
    
    private int getAliveNeighbours(int x, int y){
        int aliveOnes=0;
        
        for(int i=x-1;i<x+2;i++)
            for(int j=y-1;j<y+2;j++)
                if(getCell(i,j))
                    aliveOnes++;
        
        if(getCell(x,y))
            aliveOnes--;
        
        return aliveOnes;
    }
    
}
