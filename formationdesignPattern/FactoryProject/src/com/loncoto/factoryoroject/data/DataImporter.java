package com.loncoto.factoryoroject.data;

import java.io.File;
import java.util.Map;

public abstract class DataImporter {
	
	public abstract Map<String, String> importData();
	
	// la fonction "fabrique", celle qui choisira
	// la classe concrete du dataImporter
	// et qui saura comment l'instancier
	public static DataImporter BuildDataImporter(String filename) {
		String extension = filename.substring(filename.length() - 3);
		switch (extension) {
			case "xml":
				return new XMLDataImporter(filename);
			case "csv":
				return new CSVDataImporter(filename);
		}
		return null;
	}

}
