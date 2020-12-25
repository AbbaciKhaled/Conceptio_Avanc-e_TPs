package Inter;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;

import Vehicule.Voiture;
import Vehicule.Vehicule;

@Stateless
public class InvokedBean implements Inter {

	public Object resultat(ArrayList data) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			
			Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			Context ctx = new InitialContext(props);
			Vehicule instruction = (Vehicule) ctx.lookup("VéhiculeBean/remote");
					
			
			
			switch((Integer) data.get(0))
			{
			case 1 :
			{
				String s = instruction.insertion("Insert into vehicule values("+data.get(1)+",'"+data.get(2)+"','"+data.get(3)+"');");	
				return s;
			}
			case 2 :
			{
				String s = instruction.suppression("Delete from vehicule where Matricule="+data.get(1)+";");
				return s;
			}
			case 3 :
			{
				Voiture x = instruction.oneSelect("Select Matricule, Marque, Annee from vehicule where Matricule = "+data.get(1)+";");
				return x;
			}
			default : break;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	

}
