import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import Inter.Inter;
import Vehicule.Voiture;
public class P3 {

	
	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static Socket connection;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		
		Context ctx;
		
		try {	
			
			SocketServeur = new ServerSocket(2004);
			System.out.println("P3 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("P3 : Connection received And Accepted");

			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
			
			
			Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			ctx = new InitialContext(props);
			Inter instruction = (Inter) ctx.lookup("InvokedBean/remote");
					
			while(true)
			{
				ArrayList data  = (ArrayList) in.readObject();
				System.out.println("P2 : lit > les information envoyées par P1");
				out.writeObject("From P2 : Bien reçu");
				
				
				switch((Integer) data.get(0))
				{
				case 1:
				{
					String s = (String)instruction.resultat(data);
					out.writeObject(s);
					break;
				}
				case 2 :
				{
					String s = (String)instruction.resultat(data);
					out.writeObject(s);
					break;
				}
				case 3 :
				{
					Voiture x = (Voiture)instruction.resultat(data);
					out.writeObject(x);
					break;
				}
				default : break;
				}
				
				
				
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
