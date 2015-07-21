package com.loncoto.testthread2.util;

public class Worker2 implements Runnable {

	private Compteurpartage2 compteur;
	private String nom;
	
	public Worker2(Compteurpartage2 compteur, String nom) {
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
