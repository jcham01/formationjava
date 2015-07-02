package com.courtalon.testrmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		System.out.println("lancement du client...");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			Remote r = Naming.lookup("rmi://127.0.0.1/InfoRMI");
			System.out.println(r);
			if (r instanceof InfoService) {
				InfoService ifs = (InfoService)r;
				String str = ifs.getInfos();
				System.out.println("retour = " + str);
				
				Article[] arts = ifs.getArticles();
				System.out.println("retour2 = " + Arrays.toString(arts));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
