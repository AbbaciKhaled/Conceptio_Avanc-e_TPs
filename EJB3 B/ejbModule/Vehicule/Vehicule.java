package Vehicule;

import java.rmi.RemoteException;

import javax.ejb.Remote;

@Remote
public interface Vehicule {
	
	String insertion(String req) throws RemoteException;
	String suppression(String req) throws RemoteException;
	Voiture oneSelect(String req )  throws RemoteException;
	
	
}
