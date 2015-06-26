package metier;

public class Livre {
	
	private static int compteur = 0;
	public static int getCompteur() {
		return compteur;
	}
	
	
	private String titre;
	private String isbn;
	private double prix;
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = (prix > 0.0)? prix : 0.0;
	}
	
	
	public Livre() {
		this("inconnu", "0000000000", 0.01);
		/*System.out.println("construction livre...");
		titre = "inconnu";
		isbn = "00000000000";
		prix = 0.01;*/
	}
	
	public Livre(String titre, String isbn, double prix) {
		System.out.println("construction livre 2 ...");
		setTitre(titre);
		setIsbn(isbn);
		setPrix(prix);
		compteur++;
	}
	
	
	public void afficher() {
		System.out.println(this.titre + ", " + prix + " euros");
	}

}
