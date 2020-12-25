import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI  extends Remote{
	
	//int add(int a, int b) throws RemoteException;
	
	void inserer(Integer a, Integer b) throws RemoteException;

}
