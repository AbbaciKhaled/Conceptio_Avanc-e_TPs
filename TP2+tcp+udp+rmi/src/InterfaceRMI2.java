import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceRMI2  extends Remote{
	void afficher(Object a) throws RemoteException;
	void afficherCubique(ArrayList a) throws RemoteException;
	void afficherAmicaux(Boolean a) throws RemoteException;
}