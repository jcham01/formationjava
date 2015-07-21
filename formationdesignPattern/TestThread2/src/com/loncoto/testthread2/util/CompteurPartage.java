package com.loncoto.testthread2.util;

public class CompteurPartage {
	
	private int compteur;
	
	public CompteurPartage() {
		this.compteur = 0;
	}
	
	public int augmenteCompteur() {
		this.compteur = compteur + 1;
		return this.compteur;
	}

	
	@Override
	public String toString() {
		return "CompteurPartage [compteur=" + compteur + "]";
	}
	
	

}
