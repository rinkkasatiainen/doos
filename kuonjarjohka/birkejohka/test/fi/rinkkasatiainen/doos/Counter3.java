package fi.rinkkasatiainen.doos;

public class Counter3 implements ICounter, IResult {

	@Override
	public ICounter increment() {		
		return new OverpopulatedCounter();
	}

	@Override
	public ICell GetStateChange(AliveCell aliveCell) {		
		return new AliveCell();
	}

	@Override
	public ICell GetStateChange(DeadCell deadCell) {		
		return new AliveCell();
	}
	
}
