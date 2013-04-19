package fi.rinkkasatiainen.doos;

public class DeadCell implements ICell{

	@Override
	public ICounter Count(ICounter iCounter) {
		
		return iCounter;
	}

}
