package fi.rinkkasatiainen.doos;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFoo {
    
    @Test
    public void shouldCreateDeadCellByDefault() throws Exception{
        ConwayCell conway = new ConwayCell();
        
        assertThat(conway.isAlive(), equalTo(false));
    }
    
    @Test
    public void SetsCellStateAlive() throws Exception{
        ConwayCell conway = new ConwayCell();
        
        conway.setAlive(true);
        org.junit.Assert.assertTrue(conway.isAlive());
        
    }
    
    @Test
    public void SetsCellStateDead() throws Exception{
        ConwayCell conway = new ConwayCell();
        
        conway.setAlive(true);
        
        conway.setAlive(false);
        org.junit.Assert.assertFalse(conway.isAlive());
        
    }
    
    @Test
    public void cellPrepareDoesNotChangeState(){
        ConwayCell cell = new ConwayCell();
        
        cell.prepareSetAlive(true);
        
        assertFalse(cell.isAlive());
    }
    @Test
    public void cellExecuteDoesChangeState(){
        ConwayCell cell = new ConwayCell();
        
        cell.prepareSetAlive(true);
        
        cell.executeStateChange();
        
        assertTrue(cell.isAlive());
    }
    
    @Test
    public void safeCellGetIsDeadOutsideBounds(){
        GameBoard game = new GameBoard();
        
        assertFalse(game.getCell(-1, -1));
    }
    
    @Test
    public void setsCellatIndexesCorrectly(){
        int x = 0;
        int y = 0;
        boolean state = true;
        
        GameBoard game = new GameBoard();
        
        game.setCell(x,y,state);
        
        assertThat(game.getCell(x,y), equalTo(state));
    }
    
    
    
    
    @Test
    public void setsCellTransitiveStateCorrectly(){
        
    }
}
