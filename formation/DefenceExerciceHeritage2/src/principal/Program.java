package principal;

import java.util.Arrays;
import java.util.Random;

import geometrie.*;

public class Program {

	public static void main(String[] args) {

		Figure[] figs = new Figure[10];
		
		Random rd = new Random();
		
		for (int i = 0; i < figs.length; i++) {
			if (rd.nextBoolean()) {
				figs[i] = new Triangle(rd.nextInt(10) + 5, '#', '-');
			}
			else {
				figs[i] = new Rectangle(rd.nextInt(10) + 5,
										rd.nextInt(10) + 5 ,
										'X', 'O');
			}
		}
		
		for (Figure f : figs)
		{
			System.out.println(f.getAire());
		}
			//f.afficher();
		System.out.println("----------------------------------------");

		Arrays.sort(figs);
		for (Figure f : figs)
		{
			System.out.println(f.getAire());
		}
		
		System.out.println("----------------------------------------");
		
		Affichable a1 = figs[0];
		a1.afficher();
		
	}

}
