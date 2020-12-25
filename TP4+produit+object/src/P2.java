import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class P2 {


	public static ServerSocket SocketServeur;
	public static Socket connection;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;


	public static InterfaceRMI rmiServer;
	public static Registry registry;
	public static String Adress = "127.0.0.1";
	public static int port = 1099;
	
	public static InterfaceRMI rmiServer2;
	public static Registry registry2;
	public static String Adress2 = "127.0.0.1";
	public static int port2 = 1100;


	public static void main(String[] args) {

		try {

			SocketServeur = new ServerSocket(2004);
			System.out.println("P2 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("P2 : Connection received And Accepted");


			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());


			registry = LocateRegistry.getRegistry("127.0.0.1",port);
			System.out.println("P3 : RMI Registry found on port 1099");
			rmiServer = (InterfaceRMI) (registry.lookup("rmiServer"));
			
			registry2 = LocateRegistry.getRegistry("127.0.0.1",port2);
			System.out.println("P3 : RMI Registry found on port 1100");
			rmiServer2 = (InterfaceRMI) (registry2.lookup("rmiServer"));

			while(true) {

				ArrayList a = (ArrayList) in.readObject();
				System.out.println("Reception données de P1");
				out.writeObject("Bien Reçu From P2");

				switch((int) a.get(0)) {

				case 1:
				{
					int x = rmiServer.update("insert into produit values ('"+a.get(1)+"','"+a.get(2)+"','"+a.get(3)+"','"+a.get(4)+"');");
					int x2 = rmiServer2.update("insert into produit (id,designation,type,quantite) values ('"+a.get(1)+"','"+a.get(2)+"','"+a.get(3)+"','"+a.get(4)+"');");
					
					if (x==1 && x2==1)
						out.writeObject("Insertion terminée avec succès");
					else if(x==0 && x2==0)
						out.writeObject("Insertion échouée dans les 2 bases");
					else if(x==0)
						out.writeObject("Insertion échouée dans la base MySQL");
					else
						out.writeObject("Insertion échouée dans la base MS Access");	
					
					break;
				}


				case 2:
				{
					int x = rmiServer.update("delete from produit where id = "+a.get(1));
					int x2 = rmiServer2.update("delete from produit where id = "+a.get(1));


					if (x==1 && x2==1)
						out.writeObject("Suppression terminée avec succès");
					else if(x==0 && x2==0)
						out.writeObject("Suppression échouée dans les 2 bases");
					else if(x==0)
						out.writeObject("Suppression échouée dans la base MySQL");
					else
						out.writeObject("Suppression échouée dans la base MS Access");

					break;
				}
				
				case 3:
				{
					int x = rmiServer.update("update produit set quantite = "+a.get(2) +" where id = " +a.get(1));
					int x2 = rmiServer2.update("update produit set quantite = "+a.get(2) +" where id = " +a.get(1));


					if (x==1 && x2==1)
						out.writeObject("Modification terminée avec succès");
					else if(x==0 && x2==0)
						out.writeObject("Modification échouée dans les 2 bases");
					else if(x==0)
						out.writeObject("Modification échouée dans la base MySQL");
					else
						out.writeObject("Modification échouée dans la base MS Access");

					break;
				}

				case 4:
				{
					Produit x = rmiServer.select("select designation, quantite from produit where id = "+a.get(1));
					out.writeObject(x);
					
					Produit x2 = rmiServer2.select("select designation, quantite from produit where id = "+a.get(1));
					out.writeObject(x2);
					break;
				}
				
				case 5:
				{
					Produit x = rmiServer.select("select designation, quantite from produit where id = "+a.get(1));
					out.writeObject(x);
					
					Produit x2 = rmiServer2.select("select designation, quantite from produit where id = "+a.get(1));
					out.writeObject(x2);
					break;
				}
				
				case 6:
				{
					ArrayList <Produit> x = rmiServer.list("select designation, quantite from produit");
					out.writeObject(x);
					
					ArrayList <Produit> x2 = rmiServer2.list("select designation, quantite from produit");
					out.writeObject(x2);
					break;
				}

				}

			}

		} catch(Exception e){

		}


	}


}
