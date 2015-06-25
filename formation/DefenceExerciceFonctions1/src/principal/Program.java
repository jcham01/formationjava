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
		
		System.out.println(chiffreRomain(158));
		System.out.println(chiffreRomain(999));
		System.out.println(chiffreRomain(888));
		System.out.println(chiffreRomain(666));

		System.out.println(chiffreRomain2(999));
		System.out.println(chiffreRomain2(888));

	}
	
	
	
	// unité -> II IV VI IX
	//
	//
	
	
	public static String chiffreRomain(int nombre) {
		
		int unites = nombre % 10;
		nombre = nombre / 10;
		int dizaines = nombre % 10;
		nombre = nombre / 10;
		int centaines = nombre % 10;
		return centainesRomain(centaines) + dizainesRomain(dizaines) + unitesRomain(unites);
	}
	
	public static String chiffreRomain2(int nombre) {
		
		char[] l_unit = {'I','V','X'};
		char[] l_diz = {'X','L','C'};
		char[] l_cent = {'C','D','M'};
		
			
		int unites = nombre % 10;
		nombre = nombre / 10;
		int dizaines = nombre % 10;
		nombre = nombre / 10;
		int centaines = nombre % 10;
		return positionRomain(centaines, l_cent)
				+ positionRomain(dizaines, l_diz)
				+ positionRomain(unites, l_unit);
	}
	
	
	public static String positionRomain(int nombre, char[] lettres) {
		StringBuilder result = new StringBuilder();
		switch(nombre) {
			case 3:
				result.append(lettres[0]);
			case 2:
				result.append(lettres[0]);
			case 1:
				result.append(lettres[0]);
				break;
			case 4:
				result.append(lettres[0]);
			case 5:
				result.append(lettres[1]);
				break;
			case 8:
				result.append(lettres[0]);
			case 7:
				result.append(lettres[0]);
			case 6:
				result.append(lettres[0]);
				result.insert(0, lettres[1]);
				break;
			case 9:
				result.append(lettres[0]);
				result.append(lettres[2]);
				break;			
		}
		return result.toString();
	}

	
	
	public static String centainesRomain(int nombre) {
		StringBuilder result = new StringBuilder();
		switch(nombre) {
			case 3:
				result.append('C');
			case 2:
				result.append('C');
			case 1:
				result.append('C');
				break;
			case 4:
				result.append('C');
			case 5:
				result.append('D');
				break;
			case 8:
				result.append('C');
			case 7:
				result.append('C');
			case 6:
				result.append('C');
				result.insert(0, 'D');
				break;
			case 9:
				result.append("CM");
				break;			
		}
		return result.toString();
	}

	
	
	public static String dizainesRomain(int nombre) {
		StringBuilder result = new StringBuilder();
		switch(nombre) {
			case 3:
				result.append('X');
			case 2:
				result.append('X');
			case 1:
				result.append('X');
				break;
			case 4:
				result.append('X');
			case 5:
				result.append('L');
				break;
			case 8:
				result.append('X');
			case 7:
				result.append('X');
			case 6:
				result.append('X');
				result.insert(0, 'L');
				break;
			case 9:
				result.append("XC");
				break;			
		}
		return result.toString();
	}
	
	
	public static String unitesRomain(int nombre) {
		StringBuilder result = new StringBuilder();
		switch(nombre) {
			case 3:
				result.append('I');
			case 2:
				result.append('I');
			case 1:
				result.append('I');
				break;
			case 4:
				result.append('I');
			case 5:
				result.append('V');
				break;
			case 8:
				result.append('I');
			case 7:
				result.append('I');
			case 6:
				result.append('I');
				result.insert(0, 'V');
				break;
			case 9:
				result.append("IX");
				break;			
		}
		return result.toString();
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
