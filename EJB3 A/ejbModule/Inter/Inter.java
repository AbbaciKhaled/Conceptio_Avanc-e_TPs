package Inter;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface Inter {
	Object resultat(ArrayList data) throws RemoteException;
}
