package com.loncoto.testthread1.principal;

import com.loncoto.testthread1.util.Worker1;

public class Program {

	public static void main(String[] args) {

		Worker1 w1 = new Worker1("worker A ");
		Worker1 w2 = new Worker1("worker B ");
		Worker1 w3 = new Worker1("worker C ");
		
		// le thread est cr�e, mais non d�marr�
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);		
		
		System.out.println("d�marrage thread 1");
		t1.start();
		System.out.println("d�marrage thread 2");
		t2.start();
		System.out.println("d�marrage worker C dans main");
		w3.run();
		
		
		System.out.println("----------fini----------------");
		

	}

}
