package fi.rinkkasatiainen.doos;

public class AliveCell implements ICell{

	@Override
	public ICounter Count(ICounter iCounter) {		
		return iCounter.increment();
	}

}
