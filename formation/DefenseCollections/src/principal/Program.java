package principal;

import java.util.*;
import java.util.Map.Entry;

public class Program {

	public static void main(String[] args) {
		
		ArrayList tableau1 = new ArrayList();
		tableau1.add("lundi");
		tableau1.add("mardi");
		tableau1.add("mercredi");
		tableau1.add("jeudi");
		
		for (Object o : tableau1)
		{
			System.out.println(o);
		}
		
		tableau1.add(2, "toto");
		System.out.println("-------------");
		for (Object o : tableau1)
		{
			System.out.println(o);
		}

		
		System.out.println("-------------");
		String str = (String)tableau1.get(3);
		System.out.println(str);
		
		ArrayList<String> tab2 = new ArrayList<String>();
		tab2.add("fraise");
		tab2.add("framboise");
		tab2.add("peche");
		
		str = tab2.get(1);
		
		//tab2.add("titi");
		
		
		//----------------------------------------------------------
		System.out.println("------------------------------");
		HashMap<String, Double> map1 = new HashMap<String, Double>();
		map1.put("fraise", 15.99);
		map1.put("framboise", 22.99);
		map1.put("peche", 7.99);
		
		System.out.println(map1.get("framboise"));
		
		System.out.println("------------------------------");
		
		for (String cle : map1.keySet()) {
			System.out.println(cle + " -> " + map1.get(cle));
		}

		System.out.println("------------------------------");
		
		for (Entry<String, Double> entree : map1.entrySet()) {
			System.out.println(entree);
		}
		
		Paire<String, Double> p1 = new Paire<String, Double>("bob", 45.5);
		//p1.setValeur1("toto");
		
		Paire<Double, String> p2;
		//p2 = p1;
		
		System.out.println("-------------------");
		Intervale i1 = new Intervale(3, 12);
		System.out.println(i1);
		for (Integer i : i1) {
			System.out.println(i);
		}
		
		//Collections.so
	}

}
