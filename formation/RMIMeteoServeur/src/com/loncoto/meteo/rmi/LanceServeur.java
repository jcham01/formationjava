package com.loncoto.meteo.rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {

	public static void main(String[] args) {
		
		try 
		{
			// creation d'un "annuaire" des services
			// remote que l'on va fournir
			LocateRegistry.createRegistry(1099);
			// met en place le gestionaire de "policy"
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			// j'instancie mon fournisseur de service meteo
			MeteoServiceImpl meteosrv = new MeteoServiceImpl();
			
			// je construit l'url de mon service
			String adresse = "rmi://" + InetAddress.getLocalHost().getHostAddress()
					+ "/meteoRMI";
			System.out.println("url = " + adresse);
			
			// j'associe l'url a mon service
			Naming.bind(adresse, meteosrv);
			
			
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
