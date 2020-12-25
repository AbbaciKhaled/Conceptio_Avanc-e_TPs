import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceRMI   extends Remote{

	Integer update(String req) throws RemoteException;
	String select(String req) throws RemoteException;
	String list(String req) throws RemoteException;

	
}
