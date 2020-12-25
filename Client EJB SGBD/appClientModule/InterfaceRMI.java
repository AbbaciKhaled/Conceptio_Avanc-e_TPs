import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface InterfaceRMI extends Remote{

	Object traitement(ArrayList data) throws RemoteException;
	
}
