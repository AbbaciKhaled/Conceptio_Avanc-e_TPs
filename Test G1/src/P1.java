import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class P1 {

	
	public static InterfaceRMI rmiServer;
	public static Registry registry;
	public static String Adress = "127.0.0.1";
	public static int Port = 1099;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1",1099);
			System.out.println("P1 : RMI Registry found on port 1099");
			rmiServer = (InterfaceRMI) (registry.lookup("rmiServer"));
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Donner N : ");
			Integer N = scan.nextInt();
			
			Integer S1 = N*2;
			
		
 			
			
			rmiServer.inserer(N,S1);
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
