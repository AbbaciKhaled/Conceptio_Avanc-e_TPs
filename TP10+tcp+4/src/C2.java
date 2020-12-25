import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class C2 {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
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
				
				
				ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
				int N = (int) in.readObject();
				System.out.println("C2 : lit > N = "+N);
				
				ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
				out.writeObject("From C2 : Bien reçu");
				
				Scanner scan = new Scanner(System.in);
				System.out.print("Donner M : ");
				int M = Integer.parseInt(scan.next());

				//Envoyer N et M
				out= new ObjectOutputStream(SocketClient.getOutputStream());
				out.writeObject(N);
				System.out.println("C2 : envoi > N = "+N);
				
				in = new ObjectInputStream(SocketClient.getInputStream());	
				System.out.println(in.readObject());
				
				
				out= new ObjectOutputStream(SocketClient.getOutputStream());

				out.writeObject(M);
				System.out.println("C2 : envoi > N = "+M);
				 
				in = new ObjectInputStream(SocketClient.getInputStream());	
				System.out.println(in.readObject());
			
				
				in = new ObjectInputStream(SocketClient.getInputStream());
				int S = (int) in.readObject();
				System.out.println("C2 lit > S = "+S);
				
				out= new ObjectOutputStream(SocketClient.getOutputStream());
				out.writeObject("From C2 : Bien reçu");
				
				
				in = new ObjectInputStream(SocketClient.getInputStream());		
				int Sd = (int) in.readObject();
				
				System.out.println("C2 lit > Sd = "+Sd);	
				out= new ObjectOutputStream(SocketClient.getOutputStream());

				out.writeObject("From C2 : Bien reçu");
				out= new ObjectOutputStream(connection.getOutputStream());

				out.writeObject(S);
				System.out.println("C2 : envoi > S = "+S);
				in = new ObjectInputStream(connection.getInputStream());
				System.out.println(in.readObject());
				
				out= new ObjectOutputStream(connection.getOutputStream());
				out.writeObject(Sd);
				
				System.out.println("C2 : envoi > Sd = "+Sd);
				in = new ObjectInputStream(connection.getInputStream());
				System.out.println(in.readObject());

			}
			
			
			/*
			out.close();
			in.close();
			SocketServeur.close();
			*/
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
