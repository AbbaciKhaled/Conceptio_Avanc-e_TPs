import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Calcule.Calcule;

/**
 * 
 */

/**
 * @author dell
 *
 */
public class ClientTest {

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
		Calcule op = (Calcule) ctx.lookup("CalculeBean/remote");
		
		System.out.println("X + Y = "+op.Add(8, 4));
		System.out.println("X * Y = "+op.Mul(8, 4));
		System.out.println("X / Y = "+op.Div(8, 4));

	}

}
