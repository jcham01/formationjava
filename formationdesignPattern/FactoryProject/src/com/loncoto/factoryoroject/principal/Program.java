package com.loncoto.factoryoroject.principal;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.loncoto.factoryoroject.data.DataImporter;

public class Program {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("nom du fichier a importer?");
		String name = reader.nextLine();
		
		DataImporter di = DataImporter.BuildDataImporter(name);
		
		Map<String, String> data  = di.importData();
		
		for (Entry<String, String> et : data.entrySet())
			System.out.println(et);

	}

}
