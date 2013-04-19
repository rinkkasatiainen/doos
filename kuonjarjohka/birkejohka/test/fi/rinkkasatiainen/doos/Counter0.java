package fi.rinkkasatiainen.doos;

public class Counter0 extends DeadResult implements ICounter {

	@Override
	public ICounter increment() {		
		return new Counter1();
	}

}
