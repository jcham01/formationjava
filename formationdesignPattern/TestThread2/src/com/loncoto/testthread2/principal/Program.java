package com.loncoto.testthread2.principal;

import java.util.Vector;

import com.loncoto.testthread2.util.CompteurPartage;
import com.loncoto.testthread2.util.Compteurpartage2;
import com.loncoto.testthread2.util.Worker1;
import com.loncoto.testthread2.util.Worker2;

public class Program {

	public static void main(String[] args) {
		
		Compteurpartage2 compteur = new Compteurpartage2();
		Thread t1 = new Thread(new Worker2(compteur, "w1"));
		Thread t2 = new Thread(new Worker2(compteur, "w2"));
		Thread t3 = new Thread(new Worker2(compteur, "w3"));
		
		
		System.out.println("demarrage");
		System.out.println(compteur);
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(compteur);
		
	}

}
