package com.courtalon.testrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class InfoServiceImpl extends UnicastRemoteObject implements InfoService {

	private static final long serialVersionUID = 8495823584429486791L;
	private Article[] articles;
	
	public InfoServiceImpl() throws RemoteException {
		super();
		articles = new Article[]{
				new Article(1, "table tek", 45.5, 3.5),
				new Article(2, "chaise design", 25.5, 1.5),
				new Article(3, "canape sky vert", 155.55, 10.5)
		};
	}
	@Override
	public String getInfos() throws RemoteException {
		System.out.println("appel du service remote getInfos");
		return "bonjour, nous sommes le " + new Date();
	}
	@Override
	public Article[] getArticles() throws RemoteException {
		
		return articles;
	}

}
