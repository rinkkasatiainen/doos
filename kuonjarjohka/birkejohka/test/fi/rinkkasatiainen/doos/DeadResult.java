package fi.rinkkasatiainen.doos;

public class DeadResult implements IResult{

	@Override
	public ICell GetStateChange(AliveCell aliveCell) {		
		return new DeadCell();
	}

	@Override
	public ICell GetStateChange(DeadCell deadCell) {	
		return new DeadCell();
	}
	
}
