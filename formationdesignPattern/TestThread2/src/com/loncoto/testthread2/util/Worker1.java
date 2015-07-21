package com.loncoto.testthread2.util;

public class Worker1 implements Runnable {

	private CompteurPartage compteur;
	private String nom;
	
	public Worker1(CompteurPartage compteur, String nom) {
		this.compteur = compteur;
		this.nom = nom;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			compteur.augmenteCompteur();
			if (i % 10000000 == 0)
				System.out.println(nom + " i = " + i);
		}

	}

}
