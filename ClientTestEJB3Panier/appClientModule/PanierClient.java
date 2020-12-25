import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Panier.Panier;

/**
 * 
 */

/**
 * @author dell
 *
 */
public class PanierClient {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Properties props = System.getProperties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
		Context ctx = new InitialContext(props);

		Panier monPanier = (Panier) ctx.lookup("PanierBean/remote");
		monPanier.ajouterArticle(635);
		monPanier.ajouterArticle(543);

		System.out.println("=============================");

		Vector mesArticles = monPanier.listArticles();
		System.out.println("Il y a "+mesArticles.size()+" article(s) dans le panier !");
		Enumeration e = mesArticles.elements();
		while(e.hasMoreElements())
			System.out.println((Integer) e.nextElement());

		monPanier.ajouterArticle(323);
		monPanier.ajouterArticle(158);
		monPanier.supprimerArticle(635);

		System.out.println("=============================");

		mesArticles = monPanier.listArticles();
		System.out.println("Il y a "+mesArticles.size()+" article(s) dans le panier !");
		e = mesArticles.elements();
		while(e.hasMoreElements())
			System.out.println((Integer) e.nextElement());

		monPanier.remove();


	}

}
