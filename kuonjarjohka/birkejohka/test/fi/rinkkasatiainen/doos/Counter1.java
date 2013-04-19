package fi.rinkkasatiainen.doos;

public class Counter1 extends DeadResult implements ICounter {

	@Override
	public ICounter increment() {		
		return new Counter2();
	}	

}
