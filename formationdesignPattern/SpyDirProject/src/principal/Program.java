package principal;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		SpyDirManager spm = new SpyDirManager("repertoires.xml");
		spm.startSpies();
		System.out.println("d�marr�....");
		input.nextLine();
		spm.stopSpying();
		System.out.println("fini...");
	}

}
