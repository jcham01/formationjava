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
		System.out.println("appel de hasNext sur position " + position);
		return position <= inter.getFin();
	}

	@Override
	public Integer next() {
		System.out.println("appel de next avec pos=" + position);
		return position++;
	}



}
