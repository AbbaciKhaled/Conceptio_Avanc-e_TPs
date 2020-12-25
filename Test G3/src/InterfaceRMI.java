import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI  extends Remote{
	
	//int add(int a, int b) throws RemoteException;
	
	
	int inserer(Integer a) throws RemoteException;

}
