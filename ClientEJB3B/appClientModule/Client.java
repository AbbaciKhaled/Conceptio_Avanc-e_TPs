import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Vehicule.Vehicule;

/**
 * 
 */

/**
 * @author dell
 *
 */
public class Client {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		try {
			Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			Context ctx = new InitialContext(props);
			Vehicule op = (Vehicule) ctx.lookup("VéhiculeBean/remote");
			
			//op.requete("Insert into vehicule values (15,'206',2005)");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
