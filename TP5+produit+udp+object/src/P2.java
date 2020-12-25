import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class P2 {


	public static DatagramSocket serverSocket;
	public static byte[] receiveData;
	public static byte[] sendData;
	public static DatagramPacket sendPacket;
	public static DatagramPacket receivePacket;
	public static InetAddress IpAddress;
	public static int port3;


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

			serverSocket = new DatagramSocket(9876);


			registry = LocateRegistry.getRegistry("127.0.0.1",port);
			System.out.println("P3 : RMI Registry found on port 1099");
			rmiServer = (InterfaceRMI) (registry.lookup("rmiServer"));

			registry2 = LocateRegistry.getRegistry("127.0.0.1",port2);
			System.out.println("P3 : RMI Registry found on port 1100");
			rmiServer2 = (InterfaceRMI) (registry2.lookup("rmiServer"));

			while(true) {


				receiveData = new byte[1000];
				sendData = new byte[1000];
				receivePacket = new DatagramPacket (receiveData,receiveData.length);
				serverSocket.receive(receivePacket);
				String a[] = new String(receivePacket.getData()).trim().split(",");
				System.out.println("P3 : Reception des données");
				IpAddress = receivePacket.getAddress();
				port = receivePacket.getPort();



				System.out.println("Reception données de P1");

				sendData = "Bien Reçu From P2".getBytes();
				sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
				serverSocket.send(sendPacket);


				switch(Integer.parseInt(a[0])) {

				case 1:
				{
					System.out.println(("insert into produit values ('"+a[1]+"','"+a[2]+"','"+a[3]+"','"+a[4]+"');"));
					int x = rmiServer.update("insert into produit values ('"+a[1]+"','"+a[2]+"','"+a[3]+"','"+a[4]+"');");
					int x2 = rmiServer2.update("insert into produit (id,designation,type,quantite) values ('"+a[1]+"','"+a[2]+"','"+a[3]+"','"+a[4]+"');");

					if (x==1 && x2==1)
					{
						sendData = new byte[1000];
						sendData = "Insertion terminée avec succès".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==0 && x2==0)
					{
						sendData = new byte[1000];
						sendData = "Insertion échouée dans les 2 bases".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==0)
					{
						sendData = new byte[1000];
						sendData = "Insertion échouée dans la base MySQL".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else
					{
						sendData = new byte[1000];
						sendData = "Insertion échouée dans la base MS Access".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
			

					break;
				}


				case 2:
				{
					int x = rmiServer.update("delete from produit where id = "+a[1]);
					int x2 = rmiServer2.update("delete from produit where id = "+a[1]);


					if (x==1 && x2==1)
					{
						sendData = new byte[1000];
						sendData = "Suppression terminée avec succès".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==0 && x2==0)
					{
						sendData = new byte[1000];
						sendData = "Suppression échouée dans les 2 bases".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==0)
					{
						sendData = new byte[1000];
						sendData = "Suppression échouée dans la base MySQL".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else
					{
						sendData = new byte[1000];
						sendData = "Suppression échouée dans la base MS Access".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}

					break;
				}

				case 3:
				{
					int x = rmiServer.update("update produit set quantite = "+a[2] +" where id = " +a[1]);
					int x2 = rmiServer2.update("update produit set quantite = "+a[2] +" where id = " +a[1]);


					if (x==1 && x2==1)
					{
						sendData = new byte[1000];
						sendData = "Modification terminée avec succès".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==0 && x2==0)
					{
						sendData = new byte[1000];
						sendData = "Modification échouée dans les 2 bases".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==0)
					{
						sendData = new byte[1000];
						sendData = "Modification échouée dans la base MySQL".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else
					{
						sendData = new byte[1000];
						sendData = "Modification échouée dans la base MS Access".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}


					break;
				}
				
				case 4:
				{
					Produit x = rmiServer.select("select designation, quantite from produit where id = "+a[1]);

					Produit x2 = rmiServer2.select("select designation, quantite from produit where id = "+a[1]);
					
					if (x!=null && x2!=null)
					{
						sendData = new byte[1000];
						sendData = "Recherche terminée avec succès".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==null && x2==null)
					{
						sendData = new byte[1000];
						sendData = "Recherche échouée dans les 2 bases".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else if(x==null)
					{
						sendData = new byte[1000];
						sendData = "Recherche échouée dans la base MySQL".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}
					else
					{
						sendData = new byte[1000];
						sendData = "Modification échouée dans la base MS Access".getBytes();
						sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
						serverSocket.send(sendPacket);
					}

					
					
					break;
				}

				case 5:
				{
					Produit x = rmiServer.select("select designation, quantite from produit where id = "+a[1]);

					Produit x2 = rmiServer2.select("select designation, quantite from produit where id = "+a[1]);
					
					sendData = new byte[1000];
					sendData = new String("Désignation : "+x.getDesignation() + "Qauntité : "+x.getQuantite()).getBytes();
					sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
					serverSocket.send(sendPacket);
					
					sendData = new byte[1000];
					sendData = new String("Désignation : "+x2.getDesignation() + "Qauntité : "+x2.getQuantite()).getBytes();
					sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
					serverSocket.send(sendPacket);
					
					break;
				}

				case 6:
				{
					ArrayList <Produit> x = rmiServer.list("select designation, quantite from produit");

					String c="";
					
					for(int i=0;i<x.size();i++)
						c+= new String("Désignation : "+x.get(i).getDesignation() + " Qauntité : "+x.get(i).getQuantite())+"\n";
						
					

					sendData = new byte[1000];
					sendData = c.getBytes();
					sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
					serverSocket.send(sendPacket);
					
					
					ArrayList <Produit> x2 = rmiServer2.list("select designation, quantite from produit");

					String c2="";

					
					for(int i=0;i<x2.size();i++)
						c2+= new String("Désignation : "+x2.get(i).getDesignation() + "Qauntité : "+x2.get(i).getQuantite())+"\n";
					
					sendData = new byte[1000];
					sendData = c2.getBytes();
					sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
					serverSocket.send(sendPacket);
					break;
				}

				}

			}

		} catch(Exception e){

		}


	}


}
