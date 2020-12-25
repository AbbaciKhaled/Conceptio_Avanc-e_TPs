import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C3 {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static Socket connection;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			SocketServeur = new ServerSocket(2005);
			System.out.println("C3 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C3 : Connection received And Accepted");

			SocketClient = new Socket ("localhost",3005);
			System.out.println("C3 : Connected to localhost in port 3005");

				

			
		
			
			while(true)
			{
				//lire N et M



				ObjectInputStream  in = new ObjectInputStream(connection.getInputStream());
				
				int N = (int) in.readObject();
				System.out.println("C3 lit > N = "+N);	
				ObjectOutputStream  out = new ObjectOutputStream(connection.getOutputStream());

				out.writeObject("From C3 : Bien reçu");
				in = new ObjectInputStream(connection.getInputStream());
				
				int M = (int) in.readObject();
				System.out.println("C3 lit > N = "+M);
				out = new ObjectOutputStream(connection.getOutputStream());

				out.writeObject("From C3 : Bien reçu");

				//calculs
				int S = N*M;

				int Pr = 1;

				for (int i=2;i<S;i++)
					Pr+=i;

				int Sd = 0;

				for (int i=2;i<=Pr;i++)
					if(Pr%i==0)
						Sd+=i;
				out = new ObjectOutputStream(connection.getOutputStream());

				out.writeObject(S);
				System.out.println("C3 : envoi > S = "+S);
				in = new ObjectInputStream(connection.getInputStream());
				
				System.out.println(in.readObject());
				out = new ObjectOutputStream(connection.getOutputStream());

				out.writeObject(Sd);
				System.out.println("C3 : envoi > S = "+Sd);
				in = new ObjectInputStream(connection.getInputStream());
				
				System.out.println(in.readObject());

				//Envoyer S et Pr à P4

				

				out = new ObjectOutputStream(SocketClient.getOutputStream());
				
				out.writeObject(S);
				System.out.println("C3 : envoi > S = "+S);
				in = new ObjectInputStream(SocketClient.getInputStream());	

				System.out.println(in.readObject());
				out = new ObjectOutputStream(SocketClient.getOutputStream());
				
				out.writeObject(Pr);
				System.out.println("C3 : envoi > Pr = "+Pr);
				in = new ObjectInputStream(SocketClient.getInputStream());	

				System.out.println(in.readObject());
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
