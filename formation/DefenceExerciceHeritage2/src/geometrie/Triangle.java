package geometrie;

public class Triangle extends Figure {

	private int taille;
	
	public int getTaille() {return taille;}
	public void setTaille(int taille) {this.taille = taille;}

	public Triangle(int taille, char bord, char centre) {
		super(bord, centre);
		setTaille(taille);
	}

	@Override
	public void afficher() {
		for (int ligne = 0; ligne < taille; ligne++)
		{
			for (int colonne = 0; colonne < taille - ligne; colonne++)
			{
				if (ligne == 0 || colonne == 0 || colonne == taille - ligne - 1)
					System.out.print(getBord());
				else
					System.out.print(getCentre());
			}
			System.out.println();
		}
	}
	@Override
	public double getAire() {
		return getTaille() * getTaille() / 2.0;
	}

}
