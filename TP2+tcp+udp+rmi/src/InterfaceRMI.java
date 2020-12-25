import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI  extends Remote{
	
	//int add(int a, int b) throws RemoteException;
	
	void mul(int a, int b) throws RemoteException;
	void cubique(int a) throws RemoteException;
	void envoyer(String a) throws RemoteException;

}
