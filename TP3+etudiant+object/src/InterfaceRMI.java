import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceRMI   extends Remote{

	Integer update(String req) throws RemoteException;
	Student select(String req) throws RemoteException;
	ArrayList<Student> list(String req) throws RemoteException;

	
}
