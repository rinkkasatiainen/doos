package fi.rinkkasatiainen.doos;

public class Counter2 implements ICounter, IResult {

	@Override
	public ICounter increment() {
		return new Counter3();
	}

	@Override
	public ICell GetStateChange(AliveCell aliveCell) {		
		return new AliveCell();
	}

	@Override
	public ICell GetStateChange(DeadCell deadCell) {		
		return new DeadCell();
	}

}
