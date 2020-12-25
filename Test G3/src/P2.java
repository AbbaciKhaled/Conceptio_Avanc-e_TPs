import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P2 {

	public static DatagramSocket serverSocket;
	public static byte[] receiveData;
	public static byte[] sendData;
	public static DatagramPacket sendPacket;
	public static DatagramPacket receivePacket;
	public static InetAddress IpAddress;
	public static int port ;
	
	
	public static InterfaceRMI rmiServer;
	public static Registry registry;
	public static String Adress = "127.0.0.1";
	public static int Port = 1099;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			serverSocket = new DatagramSocket(9876);
			
			receiveData = new byte[50];
			sendData = new byte[50];
			receivePacket = new DatagramPacket (receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
			String N = new String(receivePacket.getData()).trim();
			System.out.println("P3 : Lecture de N = "+N);
			IpAddress = receivePacket.getAddress();
			port = receivePacket.getPort();

			sendData = "From P3 : N Bien reçu".getBytes();
			sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
			serverSocket.send(sendPacket);
			
			
			registry = LocateRegistry.getRegistry("127.0.0.1",1099);
			System.out.println("P3 : RMI Registry found on port 1099");
			rmiServer = (InterfaceRMI) (registry.lookup("rmiServer"));
			
			rmiServer.inserer(Integer.parseInt(N)*2);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
