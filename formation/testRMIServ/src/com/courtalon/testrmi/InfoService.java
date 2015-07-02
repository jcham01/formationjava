package com.courtalon.testrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InfoService extends Remote
{
	public String getInfos() throws RemoteException;
	public Article[] getArticles() throws RemoteException;
}
