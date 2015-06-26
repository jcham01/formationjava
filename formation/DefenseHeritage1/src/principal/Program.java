package principal;

import java.util.Random;

import metier.*;

public class Program {

	public static void main(String[] args) {
		
		//Personne p1 = new Personne("courtalon", "vincent");
		/*System.out.println(p1.getNom());
		
		Object o1 = p1;
		System.out.println(o1.toString());
		
		
		//o1 = new Object();
		Personne p2 = (Personne)o1;
		System.out.println(p2);
		*/
		Client c1 = new Client("bob",
								"l'eponge",
								"bob@pineaple.com",
								150.0);
		System.out.println(c1);
		c1.afficher();
		
		
		Personne[] peoples = new Personne[10];
		Random rd = new Random();
		for (int i= 0; i < 10; i++)
		{
			if (rd.nextBoolean()){
				peoples[i] = new Client("bob" + i, "joe"+ i,
						"bob"+ i +"@email.com", 150.0);
			}
			else
			{
				peoples[i] = new Employe("sarah" +i,
								"conor"+ i,
								"012345678" +i);
			}
		}	
		
		System.out.println("----------------------");
		
		for (Personne p: peoples) {
			p.contacter("bonjour");
			if (p instanceof Client) {
				Client c = (Client)p;
				System.out.println(c.getSolde());
			}
		}
		
		
		
	}

}
