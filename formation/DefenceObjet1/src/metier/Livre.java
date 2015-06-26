package metier;

public class Livre {
	
	public String titre;
	public String isbn;
	public double prix;

	public Livre() {
		System.out.println("construction livre...");
		titre = "inconnu";
		isbn = "00000000000";
		prix = 0.01;
	}
	
	public Livre(String titre, String isbn, double prix) {
		System.out.println("construction livre 2 ...");
		this.titre = titre;
		this.isbn = isbn;
		this.prix = prix;
	}
	
	
	public void afficher() {
		System.out.println(this.titre + ", " + prix + " euros");
	}

}
