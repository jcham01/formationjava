package echec;

// cette classe n'aura jamais d'instances
public abstract class Piece {
	// pour la lisibilité, j'utilise des constantes
	public static final int BLANCHE = 0;
	public static final int NOIRE = 1;
	public static final String colonnes = "ABCDEFGH";
	
	private int positionX;
	private int positionY;
	private int couleur;
	
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = (positionX < 1 || positionX > 8)? 1 : positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = (positionY < 1 || positionY > 8)? 1 : positionY;
	}
	public int getCouleur() {
		return couleur;
	}
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	
	// attetion, le constructeur par défaut n'est plus fournit maintenant
	public Piece(int positionX, int positionY, int couleur) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.couleur = couleur;
	}
	
	// charge au pieces "concretes" de définir leur déplacements
	public abstract String getMouvements();
	

}
