import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C3 {
	
	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static Socket connection;
	
	public static boolean Premier(int x){
		for (int i=2; i<x; i++)
		{
			if(x%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			SocketServeur = new ServerSocket(2005);
			System.out.println("C3 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C3 : Connection received And Accepted");

			SocketClient = new Socket ("localhost",2003);
			System.out.println("C3 : Connected to localhost in port 2003");

			while(true)
			{
				//lire N et M
				

				
				out = new ObjectOutputStream(connection.getOutputStream());
				in = new ObjectInputStream(connection.getInputStream());
				
				int N = (int) in.readObject();
				System.out.println("C3 lit > N = "+N);	
				out.writeObject("From C3 : Bien reçu");
				
				int M = (int) in.readObject();
				System.out.println("C3 lit > N = "+M);
				out.writeObject("From C3 : Bien reçu");
				
				//calculs
				int S = N+M;
				
				int Pr = 1;
				
				for (int i=2;i<=S;i++)
					if (Premier(i)) { Pr*=i;}
				
				
				//Envoyer S et Pr
				
				out = new ObjectOutputStream(SocketClient.getOutputStream());
				in = new ObjectInputStream(SocketClient.getInputStream());		
				
				out.writeObject(S);
				System.out.println("C3 : envoi > S = "+S);
				System.out.println(in.readObject());
				
				out.writeObject(Pr);
				System.out.println("C3 : envoi > Pr = "+Pr);
				System.out.println(in.readObject());
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());
		}

	}
}
