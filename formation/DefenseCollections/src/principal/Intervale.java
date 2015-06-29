package principal;

import java.util.Iterator;

public class Intervale implements Iterable<Integer>
{
	private int debut;
	private int fin;
	public int getDebut() {
		return debut;
	}
	public void setDebut(int debut) {
		this.debut = debut;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	
	public Intervale(int debut, int fin) {
		setDebut(debut);
		setFin(fin);
	}
	
	@Override
	public String toString() {
		return "Intervale [debut=" + debut + ", fin=" + fin + "]";
	}
	@Override
	public Iterator<Integer> iterator() {
		return new IntervalIterator(this);
	}
	
	
	
	
}
