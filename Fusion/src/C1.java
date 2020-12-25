import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C1 {

	public static ServerSocket SocketServeur;
	public static Socket connection;
	
	public static ServerSocket SocketServeur2;
	public static Socket connection2;
	
	public static Socket SocketClient;
	
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			SocketClient = new Socket ("localhost",3004);
			System.out.println("C1 : Connected to localhost in port 3004");
			
	
			SocketServeur = new ServerSocket(3003);
			System.out.println("C1 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C1 : Connection received And Accepted");
			
			SocketServeur2 = new ServerSocket(4000);
			System.out.println("C1 : Waiting for connection P0");
			connection2 = SocketServeur2.accept();
			System.out.println("C1 : Connection received And Accepted P0");
			
				
			while (true)
			{
				
				//lire N
				out = new ObjectOutputStream(connection2.getOutputStream());
				in = new ObjectInputStream(connection2.getInputStream());
				String N = (String) in.readObject();
				out.writeObject("Bien reçu from C1");

				
				//envoyer a C2
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
			System.out.println("Exception !!! ");
			e.printStackTrace();
		}
	}

}
