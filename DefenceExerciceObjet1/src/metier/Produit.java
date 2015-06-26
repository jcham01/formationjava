package metier;

public class Produit {
	
	// attributs
	private int id;
	private String nom;
	private double prix;
	private double poids;
	
	// getter/setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	// constructeurs
	
	public Produit() {
		this(0, "");
	}
	public Produit(int id, String nom) {
		this(id, nom, 0.0, 0.0);
	}
	public Produit(int id, String nom, double prix, double poids) {
		setId(id);
		setNom(nom);
		setPoids(poids);
		setPrix(prix);
	}
	
	
	public double getPrice(int quantite) {
		quantite = (quantite <0)? 0 : quantite;
		double total = getPrix() * quantite;
		return (quantite >= 10)? total * 0.95 : total;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix
				+ ", poids=" + poids + "]";
	}
	
	// methodes
	
	
/*	
	public String toString() {
		return "Produit[" + getId() +", " + getNom() + ", " + getPrix() + "]"; 
	}
*/
	
	
	

}
