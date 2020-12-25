import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C4 {

	public static ServerSocket SocketServeur;
	public static Socket SocketClient;
	public static Socket connection;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			SocketServeur = new ServerSocket(3005);
			System.out.println("C3 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("C3 : Connection received And Accepted");

			


			while(true)
			{
				//lire N et M

				ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
				int S = (int) in.readObject();
				System.out.println("C3 lit > S = "+S);	
				ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
				out.writeObject("From C4 : Bien reçu");

				
				in = new ObjectInputStream(connection.getInputStream());
				int Pr = (int) in.readObject();
				System.out.println("C3 lit > Pr = "+Pr);
				out = new ObjectOutputStream(connection.getOutputStream());
				out.writeObject("From C4 : Bien reçu");


				for (int i=1;i<9;i++)
					System.out.println(Pr +" * " +i+ " = "+Pr*i);

				int fact = 1;
				for (int i=2;i<=S;i++)
					fact*=i;
				System.out.println(S +"! = "+fact);

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
