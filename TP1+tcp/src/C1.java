import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C1 {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static Socket connection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			SocketClient = new Socket ("localhost",2004);
			System.out.println("C1 : Connected to localhost in port 2004");
			
	
			SocketServeur = new ServerSocket(2003);
			System.out.println("C1 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C1 : Connection received And Accepted");
			
				
			while (true)
			{
				
				//lire N et envoyer a C2
				out = new ObjectOutputStream(SocketClient.getOutputStream());
				in = new ObjectInputStream(SocketClient.getInputStream());
				Scanner scan = new Scanner(System.in);
				System.out.print("Donner N : ");
				int N = Integer.parseInt(scan.next());
				
				out.writeObject(N);
				System.out.println("C1 : envoi > N = "+N);
				System.out.println(in.readObject());
				
				
				//Affichage S et Pr	
				out = new ObjectOutputStream(connection.getOutputStream());
				in = new ObjectInputStream(connection.getInputStream());	
			
				
				
				int S = (int) in.readObject();
				System.out.println("C1 > S = "+S);
				out.writeObject("From C1 : S Bien re�u");
								
				int Pr = (int) in.readObject();
				System.out.println("C1 > Pr = "+Pr);
				out.writeObject("From C1 : Pr Bien re�u");
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
