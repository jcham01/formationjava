package com.loncoto.testthread1.util;

public class Worker1 implements Runnable
{

	private String nom;
	
	public Worker1(String nom) {
		this.nom = nom;
	}
	
	// point d'entrée, ou démarrage de l'éxécution du thread
	@Override
	public void run() {
		double d = 0.0;
		for (long l = 0; l < 1000000000; l++) {
			d =  Math.sqrt(1.0 + l);
			d = d * 2.0;
			if (l % 10000000 == 0)
				System.out.println(nom + ": l = " + l + " d = " + d);
		}
	}

}
