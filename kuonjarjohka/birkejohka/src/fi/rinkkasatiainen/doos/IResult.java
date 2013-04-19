package fi.rinkkasatiainen.doos;
import fi.rinkkasatiainen.doos.AliveCell;
import fi.rinkkasatiainen.doos.DeadCell;


public interface IResult {

	public ICell GetStateChange(AliveCell aliveCell);

	public ICell GetStateChange(DeadCell deadCell);
	
}
