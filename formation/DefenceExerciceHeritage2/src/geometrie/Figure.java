package geometrie;

public abstract class Figure extends Object implements Affichable, Comparable
{
	private char bord;
	private char centre;
	
	@Override
	public int compareTo(Object o) {
		Figure other = (Figure)o;
		if (this.getAire() < other.getAire())
			return -1;
		if (this.getAire() > other.getAire())
			return 1;
		return 0;
	}
	
	
	public char getBord() {
		return bord;
	}
	
	public void setBord(char bord) {
		this.bord = bord;
	}
	public char getCentre() {
		return centre;
	}
	public void setCentre(char centre) {
		this.centre = centre;
	}

	
	public Figure(char bord, char centre) {
		setBord(bord);
		setCentre(centre);
	}
	
	public abstract void afficher();
	public abstract double getAire();

}
