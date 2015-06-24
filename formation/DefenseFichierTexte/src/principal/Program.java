package principal;

import java.io.*;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		
		File f = new File("result.txt");
		
		System.out.println("fichier existe? " + f.exists());
		System.out.println("est ce un repertoire " + f.isDirectory());
		System.out.println("est ce un fichier " + f.isFile());
		if (f.exists() && f.isFile()) 
		{
			System.out.println("chemin absolu = " + f.getAbsolutePath());
			System.out.println("nom = " + f.getName());
			Scanner reader = new Scanner(f);
			while (reader.hasNext()) {
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		else
		{
			//f.createNewFile();
			PrintWriter writer = new PrintWriter(f);
			writer.println("bonjour depuis java");
			writer.close();
			
		}
		

	}

}
