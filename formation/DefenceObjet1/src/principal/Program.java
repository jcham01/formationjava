package principal;

//import metier.Livre;
import metier.*;

public class Program {

	public static void main(String[] args) {
		//metier.Livre l1;
		Livre l1;
		l1 = new Livre("20000 lieux sous les mers", "3435434354", 22.99);
		
		/*l1.titre = "20000 lieux sous les mers";
		l1.isbn = "3435434354";
		l1.prix =22.99;
		*/
		
		l1.afficher();
		
		
		Livre l2 = new Livre();
		/*l2.titre = "les miserables";
		l2.isbn = "12378524354";
		l2.prix = 19.99;
		*/
		System.out.println(l1.titre);
		
		Livre l3 = l1;
		l3.prix = 15.99;
		System.out.println(l1.prix);
		
		Livre l4 = new Livre();
		
		l4 = l2;
		
		
		
	}

}
