package principal;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
	/*	Scanner reader = new Scanner(System.in);
		System.out.println("votre nom?");
		String saisie = reader.nextLine();
	
		salutation(saisie);
		salutation(saisie, "Sire");
		
		String resultat = inverse(saisie);
		System.out.println(resultat);
		resultat = inverseRec(saisie);
		System.out.println(resultat);

		System.out.println(factoriel(5));
		*/
		
		int i = 4;
		int j = 6;
		
		//System.exit(0);
		
		System.out.println("i = " + i + " j = " + j );
		echange(i, j);
		System.out.println("i = " + i + " j = " + j );
		
		int[] mat = {5, 15};
		System.out.println("mat = " + Arrays.toString(mat));
		echange(mat);
		System.out.println("mat = " + Arrays.toString(mat));			
		
		
		
	}
	
	public static void echange(int[] values) {
		int z= values[0];
		values[0] = values[1];
		values[1] = z;
	}
	
	
	public static void echange(int x, int y) {
		System.out.println("x = " + x + " y = " + y );
		int z = x;
		x = y;
		y = z;
		System.out.println("x = " + x + " y = " + y );

	}
	
	
	public static long factoriel(long n) {
		if (n <= 1)
			return 1;
		return n * factoriel(n - 1);
	}
	
	
	
	public static String inverseRec(String chaine) {
		if (chaine.length() <= 1)
			return chaine;
		else
		{
			String result = chaine.charAt(chaine.length() - 1) 
					+ inverseRec(chaine.substring(0, chaine.length() - 1));
			return result;
		}
		
	}
	
	
	public static String inverse(String chaine) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = chaine.length() - 1; i >= 0; i--)
			sb.append(chaine.charAt(i));
		
		return sb.toString();
		
	}

	
	
	
	/*public static String salutation(String nom) {
		return "";
	}*/
	
	
	public static void salutation(String nom, String civilite) {
		System.out.println("bonjour, " + civilite + " " + nom);
	}
	
	public static void salutation(String nom) {
		salutation(nom, "Mr");
	}
	
	

}
