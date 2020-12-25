import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class P2 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static Socket connection;
	
	
	String Adress;
	static int Port=2010;
	
	public P2() throws RemoteException
	{
		System.out.println("Adresse Serveur = "+Adress+",Port = "+Port);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			
			SocketClient = new Socket ("localhost",2004);
			System.out.println("P2 : Connected to localhost in port 2004");


			out = new ObjectOutputStream(SocketClient.getOutputStream());
			in = new ObjectInputStream(SocketClient.getInputStream());
			
			
			P2 s = new P2();
			System.out.println("P2 Server RMI is ready");
			
			Registry registry = LocateRegistry.createRegistry(Port);
			System.out.println("P2 Created RMI registry on port "+Port);
			registry.rebind("rmiServer", s);
			
			
			

			
				

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public Object traitement(ArrayList data) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		try {
			out.writeObject(data);
			System.out.println(in.readObject());
			return (in.readObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
