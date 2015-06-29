package principal;

import java.util.Iterator;

public class IntervalIterator implements Iterator<Integer>
{

	private Intervale inter;
	private int position;
	
	public IntervalIterator(Intervale inter) {
		this.inter = inter;
		position = inter.getDebut();
	}
	
	@Override
	public boolean hasNext() {
		return position <= inter.getFin();
	}

	@Override
	public Integer next() {
		return position++;
	}



}
