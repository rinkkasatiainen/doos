package fi.rinkkasatiainen.doos;

public class OverpopulatedCounter extends DeadResult implements ICounter{
	@Override
	public ICounter increment() {		
		return new OverpopulatedCounter();
	}
}
