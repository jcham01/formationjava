package com.loncoto.factoryoroject.principal;

import com.loncoto.factoryoroject.data.CSVDataImporter;
import com.loncoto.factoryoroject.data.DataImporter;
import com.loncoto.factoryoroject.data.IDataImporter;
import com.loncoto.factoryoroject.data.XMLDataImporter;

public class DataBuilder 
{
	
	// la fonction "fabrique", celle qui choisira
		// la classe concrete du dataImporter
		// et qui saura comment l'instancier
		public static IDataImporter BuildDataImporter(String filename) {
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
