package com.loncoto.testthread2.util;

public class CompteurPartage {

	private Object verrou1;
	private Object verrou2;
	
	private int compteur1;
	private int compteur2;
	
	public CompteurPartage() {
		this.compteur1 = 0;
		this.compteur2 = 0;
		verrou1 = new Object();
		verrou2 = new Object();
	}
	
	public int augmenteCompteur() {
		synchronized (verrou1) {
			this.compteur1 = compteur1 + 1;
		}
		return this.compteur1;

	}
	
	public int augmenteCompteur2() {
		synchronized (verrou2) {
			this.compteur2 = compteur2 + 1;
		}
		return this.compteur2;
	}
	
	
/*	
	public int augmenteCompteur() {
		synchronized (this) {
			this.compteur = compteur + 1;
			return this.compteur;
		}
	}
*/
	
	@Override
	public String toString() {
		return "CompteurPartage [compteur1=" + compteur1 + "]";
	}
	
	

}
