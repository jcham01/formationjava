package com.loncoto.iteratorproject.reseau;

import java.util.Iterator;

public class IPIntervalIterator implements Iterator<Integer[]> {

	
	// interval sur lequel je vais parcourir(iterer)
	private IPInterval interval;
	private int[] current;
	
	public IPIntervalIterator(IPInterval interval) {
		this.interval = interval;
		// je me positionne sur l'ip de début
		current = interval.getIpStart();
	}
	
	
	@Override
	public boolean hasNext() {
		return interval.isInInterval(current[0], current[1], current[2], current[3]);
	}

	@Override
	public Integer[] next() {
		// je recupere l'adresse ip sous forme d'un chiffre
		long cur = ((long)current[0] << 24) + (current[1] << 16) + (current[2] << 8) + current[3];
		// j'incremente le chiffre
		cur++;
		// je sauvegarde l'ip courante pour la renvoyer
		Integer[] curip = { current[0], current[1], current[2], current[3]};
		// je réécrit l'ip incrementée a partir du chiffre incrémenté
		current[0] = (int)(cur >> 24) & 255 ;
		current[1] = (int)(cur >> 16) & 255 ;
		current[2] = (int)(cur >> 8) & 255 ;
		current[3] = (int)(cur & 255) ;
		return curip;
	}

}
