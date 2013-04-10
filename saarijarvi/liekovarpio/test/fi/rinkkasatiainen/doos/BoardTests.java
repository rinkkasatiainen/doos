/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rinkkasatiainen.doos;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 *
 * @author StarSeeker
 */
public class BoardTests {
    
    @Test
    public void creates3WideBoardByDefault(){
        GameBoard game = new GameBoard();
        
        assertThat(game.getWidth(), equalTo(3));
        
    }

    @Test
    public void creates3HighBoardByDefault(){
        GameBoard game = new GameBoard();
        
        assertThat(game.getHeight(), equalTo(3));
        
    }
    @Test
    public void loneCellShouldNotSurvive(){
        GameBoard game = new GameBoard();
        
        game.setCell(1, 1, true);
        
        game.update();
        
        assertFalse(game.getCell(1, 1));
    }
    
    @Test
    public void With2NeighboursDies(){
        GameBoard game = new GameBoard();
        
        game.setCell(1, 1, true);
        
        //this is as far as we got.
        
        for(int i=0;i<game.getWidth();i++){
            for(int j=0;j<game.getHeight();j++){
                game.setCell(i, j, false);
                
                game.setCell(i, j, false);
            }
        }
        
        game.update();
        
        assertFalse(game.getCell(1, 1));        
    }
}
