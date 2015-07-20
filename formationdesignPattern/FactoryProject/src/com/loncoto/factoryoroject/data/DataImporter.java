package com.loncoto.factoryoroject.data;

import java.util.Map;

public abstract class DataImporter {
	
	public abstract Map<String, String> importData();
	
	// la fonction "fabrique", celle qui choisira
	// la classe concrete du dataImporter
	// et qui saura comment l'instancier
	public static DataImporter BuildDataImporter(String filename) {
		return null;
	}

}
