import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Pack.ICalcule;
import Pack.CalculeBean;

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

		try {
			System.out.println("Client App Started");
			Properties props = System.getProperties();
			props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
			InitialContext ctx = new InitialContext(props);
			String appName = "";
			String moduleName = "EJB3ICalcule";
			String distinctName = "";
			String beanName = CalculeBean.class.getSimpleName();
			String interfaceName = ICalcule.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
			System.out.println(name);
			ICalcule bean = (ICalcule) ctx.lookup(name);
			System.out.println("Result : " + bean.add(15, 25));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
