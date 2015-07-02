package com.courtalon.testrmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Program {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("configuration securité");
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			InfoServiceImpl infoimpl = new InfoServiceImpl();
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() 
					+"/InfoRMI";
			System.out.println("adresse objet = " + url);
			Naming.bind(url,  infoimpl);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
