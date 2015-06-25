package principal;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		
		int[] entiers1 = {1,2,3,4,6,7,9};
		int[] entiers2 = {101,20,31,14,11,27,59};
		
		System.out.println("nombre d'impaire dans " +
					Arrays.toString(entiers1) + " = "
					+ compteImpaire(entiers1));
		System.out.println("nombre d'impaire dans " +
				Arrays.toString(entiers2) + " = "
				+ compteImpaire(entiers2));
		
		System.out.println("'serres' est un palindrome ? " + estPalindrome("serres"));
		System.out.println("'bonjour' est un palindrome ? " + estPalindrome("bonjour"));
		System.out.println("'abcdcba' est un palindrome ? " + estPalindrome("abcdcba"));
		System.out.println("'abedcba' est un palindrome ? " + estPalindrome("abedcba"));
		
		
		System.out.println("somme = 1000.0, objectif = 2000.0, taux = 5% -> "
				+ calculAnnee(1000.0, 2000.0, 0.05) + " années");
		System.out.println("somme = 1000.0, objectif = 2000.0, taux = 3% -> "
				+ calculAnnee(1000.0, 2000.0, 0.03) + " années");
		
	}
	
	public static int calculAnnee(double sommeInitiale,
								  double sommeVoulue,
								  double taux)
	{
		int annees = 0;
		for ( ; sommeInitiale <= sommeVoulue; annees++) {
			sommeInitiale += sommeInitiale * taux;
		}
	
	/*	while (sommeInitiale <= sommeVoulue) {
			sommeInitiale += sommeInitiale * taux;
			annees++;
		}*/
		return annees;
	}
	
	
	public static boolean estPalindrome(String chaine) {
		int start = 0;
		int end = chaine.length() - 1;
		while (start < end) {
			if (chaine.charAt(start) != chaine.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	
	public static int compteImpaire(int[] tab) {
		int compteur = 0;
		for (int i : tab) {
			if (i % 2 != 0) {compteur++; }
		}
		return compteur;
	}

}
