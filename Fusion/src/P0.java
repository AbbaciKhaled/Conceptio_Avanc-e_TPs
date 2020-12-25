import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class P0 {


	public static Socket SocketClient;
	public static Socket SocketClient2;
	public static Socket SocketClient3;
	public static Socket SocketClient4;


	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	public static ObjectOutputStream out2;
	public static ObjectInputStream in2;
	
	public static ServerSocket SocketServeur;
	public static Socket connection;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
	
			
			SocketClient = new Socket ("localhost",4000);
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			in = new ObjectInputStream(SocketClient.getInputStream());	
			SocketClient2 = new Socket ("localhost",5000);
			out2 = new ObjectOutputStream(SocketClient2.getOutputStream());
			in2 = new ObjectInputStream(SocketClient2.getInputStream());	
			
			SocketClient3 = new Socket ("localhost",6000);			
			SocketClient4 = new Socket ("localhost",7000);

			
			
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.print("Donner N : ");
				String N = scan.next();
				
				
				System.out.print("Donner M : ");
				String M = scan.next();
		
			

				
				try {
					
					out.writeObject(N);
					System.out.println(in.readObject());

					
					out.writeObject(M);
					System.out.println(in.readObject());

					out = new ObjectOutputStream(SocketClient3.getOutputStream());
					in = new ObjectInputStream(SocketClient3.getInputStream());	
					out.writeObject(N);
					System.out.println(in.readObject());

					
					out = new ObjectOutputStream(SocketClient4.getOutputStream());
					in = new ObjectInputStream(SocketClient4.getInputStream());	
					out.writeObject(M);
					System.out.println(in.readObject());
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				

			}
			
			

		

	
	}

}
