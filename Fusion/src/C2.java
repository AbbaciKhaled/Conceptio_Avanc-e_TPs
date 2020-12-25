import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class C2 {

	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	public static ServerSocket SocketServeur;
	public static Socket connection;

	public static ServerSocket SocketServeur2;
	public static Socket connection2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
						
			SocketServeur = new ServerSocket(3004);
			System.out.println("C2 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C2 : Connection received And Accepted");

			SocketClient = new Socket ("localhost",3005);
			System.out.println("C2 : Connected to localhost in port 3005");
			
			SocketServeur2 = new ServerSocket(5000);
			System.out.println("C2 : Waiting for connection P0");
			connection2 = SocketServeur2.accept();
			System.out.println("C2 : Connection received And Accepted P0");
			
			while(true)
			{
				
				//Lire N
				out = new ObjectOutputStream(connection.getOutputStream());
				in = new ObjectInputStream(connection.getInputStream());
				
				String N = (String) in.readObject();
				System.out.println("C2 : lit > N = "+N);
				out.writeObject("From C2 : Bien reçu");
				
				//lire M
				out = new ObjectOutputStream(connection2.getOutputStream());
				in = new ObjectInputStream(connection2.getInputStream());
				String M = (String) in.readObject();
				out.writeObject("Bien reçu from C2");
				
				
				//Envoyer N et M
				
				out= new ObjectOutputStream(SocketClient.getOutputStream());
				in = new ObjectInputStream(SocketClient.getInputStream());	
				
				out.writeObject(N);
				System.out.println("C2 : envoi > N = "+N);
				System.out.println(in.readObject());
				
				out.writeObject(M);
				System.out.println("C2 : envoi > N = "+M);
				System.out.println(in.readObject());

			}
			
			
			/*
			out.close();
			in.close();
			SocketServeur.close();
			*/
			
		}catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());
		}

	}
}
