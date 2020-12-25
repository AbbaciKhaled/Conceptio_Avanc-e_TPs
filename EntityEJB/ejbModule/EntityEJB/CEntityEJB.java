package EntityEJB;

import java.util.ArrayList;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;





import Produit.EntityProduit;
import Produit.IEntity;

@Stateless
public class CEntityEJB implements IEntityEJB{

	public ArrayList<Object> Connection(int choix,String id,String lib,int qt) {
		// TODO Auto-generated method stub
		System.out.println("choix"+choix);
		ArrayList<Object> p= new ArrayList<Object>();
		try{
			Properties props=System.getProperties();
			
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			
			Context ctx =new InitialContext(props);
			
			IEntity produit= (IEntity ) ctx.lookup("CEntity/remote");
		
			
			
			
			switch(choix){
			
			case 1: produit.add(new EntityProduit(id,lib,qt));
			
			p.add("Produit ajoute avec success");
			
			break;
			
			case 2:p.add(produit.find(id));
			
			break;
			
			case 3:p=produit.ListeProduits();
			
			break;
			}
		}
		catch(Exception e){
			e.getStackTrace();
		}
		
		return p;
	}

	public void Connection1() {
		// TODO Auto-generated method stub
		try{
			Properties props=System.getProperties();
			
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			
			Context ctx =new InitialContext(props);
			
			IEntity produit= (IEntity ) ctx.lookup("CEntity/remote");
			
			//produit.add(new EntityProduit("l",20));
			
			produit.find("l").toString();
		}catch(Exception e){
			
		}
	}

}
