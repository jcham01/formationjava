package geometrie;

public class Rectangle extends Figure {

	private int longueur;
	private int largeur;
	
	public int getLongueur() {return longueur;}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	
	public Rectangle(int longueur, int largeur, char bord, char centre) {
		super(bord, centre);
		setLongueur(longueur);
		setLargeur(largeur);
	}

	@Override
	public void afficher() {
		for (int ligne = 0; ligne < getLargeur(); ligne++)
		{
			for (int colonne = 0; colonne < getLongueur(); colonne++)
			{
				if (ligne == 0 || colonne == 0 ||
					colonne == getLongueur() - 1 || ligne == getLargeur() - 1)
					System.out.print(getBord());
				else
					System.out.print(getCentre());
			}
			System.out.println();
		}

	}
	@Override
	public double getAire() {
		return getLongueur() * getLargeur();
	}

}
