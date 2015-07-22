package com.loncoto.testthread3.principal;

import java.util.concurrent.*;

import com.loncoto.testthread3.util.Worker1;

public class Program {

	public static void main(String[] args) {
		ExecutorService srv = Executors.newFixedThreadPool(4);
		
		srv.execute(new Worker1("worker a"));
		srv.execute(new Worker1("worker b"));
		srv.execute(new Worker1("worker c"));
		srv.execute(new Worker1("worker d"));
		srv.execute(new Worker1("worker e"));
		srv.execute(new Worker1("worker f"));
		
		// termine toutes les taches planifiées
		// mais n'accepte plus de nouvelles taches
		System.out.println("attempting shutdown....");
		srv.shutdown();
		
		try {
			while (true) {
				// j'attend au maximum 2 secondes que le thread pool
				// se termine
				System.out.println("waiting for shutdown complete");
				srv.awaitTermination(2, TimeUnit.SECONDS);
				if (srv.isTerminated())
					break;
				System.out.println("not yet finished....");
			}
		} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("fini!");
		

		

	}

}
