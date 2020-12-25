import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P0 {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static Socket connection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Donner N : ");
			String N = scan.next();
			
			
			System.out.print("Donner M : ");
			String M = scan.next();
			

			SocketClient = new Socket ("192.168.43.64",2015);
			
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			out.writeObject(N);


			
			
			SocketClient = new Socket ("192.168.43.64",2013);
			
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			out.writeObject(M);
			System.out.print("Khaled2");

			
			SocketClient = new Socket ("192.168.43.187",2012);
			System.out.println("C1 : Connected to localhost in port 2004");
			
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			out.writeObject(N);
			
			SocketClient = new Socket ("192.168.43.187",2014);
			System.out.println("C1 : Connected to localhost in port 2004");
			
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			out.writeObject(N);
			
			/*
			while (true)
			{
				
				//lire N et envoyer a C2
				
				out = new ObjectOutputStream(SocketClient.getOutputStream());
				in = new ObjectInputStream(SocketClient.getInputStream());
				
				
				
				out.writeObject(N);
				System.out.println("C1 : envoi > N = "+N);
				System.out.println(in.readObject());
				
				
				//Affichage S et Pr
				
				
				out = new ObjectOutputStream(connection.getOutputStream());
				in = new ObjectInputStream(connection.getInputStream());	
				
				int S = (int) in.readObject();
				System.out.println("C1 > S = "+S);
				out.writeObject("From C1 : S Bien reçu");
								
				int Pr = (int) in.readObject();
				System.out.println("C1 > Pr = "+Pr);
				out.writeObject("From C1 : Pr Bien reçu");
			}
			
			/*
			in.close();
			out.close();
			SocketClient.close();
			*/

		}catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());
		}
	}

}
