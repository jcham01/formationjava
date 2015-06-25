package principal;

import java.io.*;
import java.util.*;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		
		File source = new File("src/principal/Program.java");
		
		String result = "";
		if (source.exists() && source.isFile())
			result = statTexte(source);
		
		File rapport = new File("rapport.txt");
		PrintWriter writer = new PrintWriter(rapport);
		writer.println(result);
		writer.close();
		System.out.println("fini!");
		
	}
	
	public static String statTexte(File document) throws FileNotFoundException {
		
		Scanner reader = new Scanner(document);
		int nbCaracteres = 0;
		int nbA = 0;
		int nbE = 0;
		int nbI = 0;
		int nbO = 0;
		int nbU = 0;
		int nbY = 0;
		int nbVoyelles = 0;
		boolean dansMot = false; // au début, nous ne somme pas dans un mot
		int nbMots = 0;
		int nbCaracteresDansMot = 0;
		
		while (reader.hasNext()) {
			String line = reader.nextLine();
			nbCaracteres += line.length();
			line = line.toUpperCase();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (Character.isAlphabetic(c) || c =='_')
				{
					// c'est un caractere de mots;
					if (!dansMot) {	nbMots++;}
					dansMot = true;
					nbCaracteresDansMot++;
				}
				else
				{
					dansMot = false;
				}
				
				switch (c) {
					case 'A':
						nbA++;
						nbVoyelles++;
						break;
					case 'E':
						nbE++;
						nbVoyelles++;
						break;
					case 'I':
						nbI++;
						nbVoyelles++;
						break;
					case 'O':
						nbO++;
						nbVoyelles++;
						break;
					case 'U':
						nbU++;
						nbVoyelles++;
						break;
					case 'Y':
						nbY++;
						nbVoyelles++;
						break;
				}
			}
			dansMot = false;
		}
		
		StringBuilder sb = new StringBuilder("nombre de caracteres = " + nbCaracteres + "\n");
		sb.append("frequence des A = " + (nbA * 100.0 / nbVoyelles) + "%\n");
		sb.append("frequence des E = " + (nbE * 100.0 / nbVoyelles) + "%\n");
		sb.append("frequence des I = " + (nbI * 100.0 / nbVoyelles) + "%\n");
		sb.append("frequence des O = " + (nbO * 100.0 / nbVoyelles) + "%\n");
		sb.append("frequence des U = " + (nbU * 100.0 / nbVoyelles) + "%\n");
		sb.append("frequence des Y = " + (nbY * 100.0 / nbVoyelles) + "%\n");
		sb.append("nombre de mots = " + nbMots + "\n");
		sb.append("longueur moyenne des mots = " + ((double)nbCaracteresDansMot / nbMots) + "\n");

		return sb.toString();
	}

}
