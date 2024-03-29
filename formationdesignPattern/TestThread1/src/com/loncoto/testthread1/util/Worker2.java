package com.loncoto.testthread1.util;

public class Worker2 extends Thread {
	
	private String nom;
	private boolean mustStop;
	public void setMustStop(boolean mustStop) {
		this.mustStop = mustStop;
	}

	public Worker2(String nom) {
		this.nom = nom;
		mustStop = false;
	}

	@Override
	public void run() {
		double d = 0.0;
		for (long l = 0; l < 1000000000; l++) {
			d =  Math.sqrt(1.0 + l);
			d = d * 2.0;
			if (l % 10000000 == 0) {
				System.out.println(nom + ": l = " + l + " d = " + d);
				if (mustStop) {
					System.out.println(nom + " a recu l'ordre de s'arreter");
					return;
				}
			}
		}
	}
	
	
	

}
