package com.loncoto.testthread2.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Compteurpartage2 {
	
	private AtomicInteger compteur;
	
	public Compteurpartage2() {
		this.compteur = new AtomicInteger(0);
	}
	
	public int augmenteCompteur() {
		// l'atomic integer garantie la coh�rence de ses op�rations
		// il n'y a plus besoin de section critique m�me en cas d'acc�s multiples
		return this.compteur.incrementAndGet();
	}
	
	@Override
	public String toString() {
		return "CompteurPartage2 [compteur=" + compteur.get() + "]";
	}
	
}
