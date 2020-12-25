import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C1 {

	public static Socket SocketClient;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			SocketClient = new Socket ("localhost",2004);
			System.out.println("C1 : Connected to localhost in port 2004");
			



			while (true)
			{

				//lire N et envoyer a C2
				Scanner scan = new Scanner(System.in);
				System.out.print("Donner N : ");
				int N = Integer.parseInt(scan.next());

				
				ObjectOutputStream out = new ObjectOutputStream(SocketClient.getOutputStream());
				out.writeObject(N);
				System.out.println("C1 : envoi > N = "+N);
				ObjectInputStream in = new ObjectInputStream(SocketClient.getInputStream());
				System.out.println(in.readObject());


				//Affichage S et Sd

				in = new ObjectInputStream(SocketClient.getInputStream());

				int S = (int) in.readObject();
				System.out.println("C1 > S = "+S);
				out = new ObjectOutputStream(SocketClient.getOutputStream());

				out.writeObject("From C1 : S Bien reçu");

				
				in = new ObjectInputStream(SocketClient.getInputStream());

				int Sd = (int) in.readObject();
				System.out.println("C1 > Pr = "+Sd);
				out = new ObjectOutputStream(SocketClient.getOutputStream());

				out.writeObject("From C1 : Pr Bien reçu");

				System.out.println("S ="+S);
				System.out.println("Sd ="+Sd);

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
