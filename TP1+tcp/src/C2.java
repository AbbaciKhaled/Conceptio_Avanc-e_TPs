import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class C2 {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static Socket connection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
						
			SocketServeur = new ServerSocket(2004);
			System.out.println("C2 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C2 : Connection received And Accepted");

			SocketClient = new Socket ("localhost",2005);
			System.out.println("C2 : Connected to localhost in port 2005");
			
			
			
			while(true)
			{
				
				//Lire N
				
				
				out = new ObjectOutputStream(connection.getOutputStream());
				in = new ObjectInputStream(connection.getInputStream());
				
				int N = (int) in.readObject();
				System.out.println("C2 : lit > N = "+N);
				out.writeObject("From C2 : Bien reçu");
				
				Scanner scan = new Scanner(System.in);
				System.out.print("Donner M : ");
				int M = Integer.parseInt(scan.next());

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
