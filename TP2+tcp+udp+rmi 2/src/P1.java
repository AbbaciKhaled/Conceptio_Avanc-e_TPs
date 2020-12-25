import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class P1 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI2 {



	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	public static ServerSocket SocketServeur;
	public static Socket connection;


	public static Registry registry;
	public static String Adress = "localhost";
	public static int Port=1100;

	protected P1() throws RemoteException {
		System.out.println("P1 : Adresse Serveur = "+Adress+",Port = "+Port);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			P1 s = new P1();	
			registry = LocateRegistry.createRegistry(Port);
			registry.rebind("rmiServer2", s);
				
			
			SocketClient = new Socket ("localhost",2004);
			System.out.println("P1 : Connected to localhost in port 2004");
			
			
			while (true)
			{
				//lire N et envoyer a P2				
				Scanner scan = new Scanner(System.in);
				System.out.println("Donner N : ");
				String N = scan.next();
				out = new ObjectOutputStream(SocketClient.getOutputStream());
				out.writeObject(N);
				System.out.println("P1 : N = "+N+" envoyée à P2");
				in = new ObjectInputStream(SocketClient.getInputStream());
				System.out.println(in.readObject());	

				TimeUnit.SECONDS.sleep(5);
				
			}

		}catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());
		}
	}

	@Override
	public void afficher(Object a) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(a);
	}

	@Override
	public void afficherCubique(ArrayList a) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Les nombres cubiques sont : "+a);
		/*Iterator<Integer> it=a.iterator();
		while(it.hasNext())
			System.out.println(it.next());*/
	}

	@Override
	public void afficherAmicaux(Boolean a) throws RemoteException {
		// TODO Auto-generated method stub
		if (a)
			System.out.println("N et M sont amicaux");
		else
			System.out.println("N et M ne sont pas amicaux");
	}

}
