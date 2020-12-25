import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class P2 {

	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			SocketClient = new Socket ("localhost",2004);
			System.out.println("P2 : Connected to localhost in port 2004");
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			in = new ObjectInputStream(SocketClient.getInputStream());
			
			

			Scanner scan = new Scanner(System.in);
			System.out.println("Donner M : ");
			Integer M = scan.nextInt();
			
			Integer S2 = M*2;
			
			
			out.writeObject(M);
			System.out.println("P2 : M = "+M+" envoyée à P2");
			System.out.println(in.readObject());	
			
			out.writeObject(S2);
			System.out.println("P2 : S2 = "+S2+" envoyée à P2");
			System.out.println(in.readObject());	
			
		}catch(Exception e)
		{
		
		}
		
		
	}

}
