package fi.rinkkasatiainen.doos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Assert;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFoo {
	
		

//    @Test
//    public void shouldDoSomeSmartMagic() throws Exception {
//        Cell lookMa_I_canMock = mock(Cell.class);
//
//        when(lookMa_I_canMock.doStuff()).thenReturn(false);
//
//        assertThat(lookMa_I_canMock.doStuff(), equalTo(true));
//    }
//    
//    @Test
//    public void shouldCreateUniverse() throws Exception
//    {
//    	Universe universe = new Universe();
//    	assertThat(universe.cellCount, greaterThan(0));
//    }

	// condition 1 (underpopulation)
	@Test
	public void counter0Change()
	{
		ICounter counter = new Counter0();
		
		counter = counter.increment();
		
		junit.framework.Assert.assertEquals(counter.getClass(), Counter1.class);
	}
	
	@Test
	public void counter1Change()
	{
		ICounter counter = new Counter1();
		
		counter = counter.increment();
		
		junit.framework.Assert.assertEquals(counter.getClass(), Counter2.class);
	}
	
	@Test
	public void counter2Change()
	{
		ICounter counter = new Counter2();
		
		counter = counter.increment();
		
		junit.framework.Assert.assertEquals(counter.getClass(), Counter3.class);
	}
	
	@Test
	public void counter3ReturnsOverpopulatedCounter()
	{
		ICounter counter = new Counter3();
		
		counter = counter.increment();
		
		junit.framework.Assert.assertEquals(counter.getClass(), OverpopulatedCounter.class);
	}
	
	@Test
	public void overpopulatedCounterReturnsOverpopulatedCounter()
	{
		ICounter counter = new OverpopulatedCounter();
		
		counter = counter.increment();
		
		junit.framework.Assert.assertEquals(counter.getClass(), OverpopulatedCounter.class);
	}	
	
	
	@Test
	public void deadResultShouldReturnDeadStateForAliveCell()
	{		
		AliveCell aliveCell = new AliveCell();			
				
		DeadResult deadResult=new DeadResult();
		ICell cell = deadResult.GetStateChange(aliveCell);
		
		junit.framework.Assert.assertEquals(cell.getClass(), DeadCell.class);
	}
	
	@Test
	public void deadResultShouldReturnDeadStateForDeadCell()
	{
		DeadCell deadCell = new DeadCell();			
		
		DeadResult deadResult=new DeadResult();
		ICell cell = deadResult.GetStateChange(deadCell);
		
		junit.framework.Assert.assertEquals(cell.getClass(), DeadCell.class);			
	}
	
	@Test
	public void counter2ShouldReturnAliveStateForAliveCell()
	{
		Counter2 counter2 = new Counter2();
		AliveCell aliveCell=new AliveCell();
		
		ICell cell = counter2.GetStateChange(aliveCell);
		
		junit.framework.Assert.assertEquals(cell.getClass(), AliveCell.class);
		
	}
	
	@Test
	public void counter2ShouldReturnDeadStateForDeadCell()
	{
		Counter2 counter2 = new Counter2();
		DeadCell deadCell=new DeadCell();
		
		ICell cell = counter2.GetStateChange(deadCell);
		
		junit.framework.Assert.assertEquals(cell.getClass(), DeadCell.class);		
	}
	
	@Test
	public void counter3ShouldReturnAliveStateForAliveCell()
	{
		Counter3 counter3 = new Counter3();
		AliveCell aliveCell=new AliveCell();
		
		ICell cell = counter3.GetStateChange(aliveCell);
		
		junit.framework.Assert.assertEquals(cell.getClass(), AliveCell.class);
		
	}
	
	@Test
	public void counter3ShouldReturnAliveStateForDeadCell()
	{
		Counter3 counter3 = new Counter3();
		DeadCell deadCell=new DeadCell();
		
		ICell cell = counter3.GetStateChange(deadCell);
		
		junit.framework.Assert.assertEquals(cell.getClass(), AliveCell.class);		
	}
	
	@Test
	public void aliveCellShouldIncrementCounter()
	{
		AliveCell aliveCell=new AliveCell();
		Counter0 counter0 = new Counter0();
		
		ICounter iCounter = aliveCell.Count(counter0);
		
		junit.framework.Assert.assertEquals(iCounter.getClass(), Counter1.class);
	}
	
	@Test
	public void deadCellShouldNotIncrementCounter()
	{
		DeadCell deadCell=new DeadCell();
		Counter0 counter0=new Counter0();
		
		ICounter iCounter=deadCell.Count(counter0);
		
		junit.framework.Assert.assertEquals(iCounter.getClass(), Counter0.class);
	}
	
}
