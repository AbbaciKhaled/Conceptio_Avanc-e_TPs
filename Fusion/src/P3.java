import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P3 {

	/*public static int somme(int x, int y)
	{
		return x+y;
	}*/

	public static int sommeDiviseurs(int x)
	{
		int som = 0;
		for (int i=1; i<x; i++)
			if(x%i==0)
				som += i;
		return som;
	}


	public static boolean amicaux(int x, int y)
	{
		if (sommeDiviseurs(x) == y && sommeDiviseurs(y) == x)
			return true;
		return false;
	}


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


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		try {
			
			serverSocket = new DatagramSocket(9876);

			registry = LocateRegistry.getRegistry("127.0.0.1",port);
			System.out.println("P3 : RMI Registry found on port 1099");
			rmiServer = (InterfaceRMI) (registry.lookup("rmiServer"));

			while(true)
			{

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


				receiveData = new byte[50];
				sendData = new byte[50];

				receivePacket = new DatagramPacket (receiveData,receiveData.length);
				serverSocket.receive(receivePacket);
				String M = new String(receivePacket.getData()).trim();
				System.out.println("P3 : Lecture de M = "+M);
				IpAddress = receivePacket.getAddress();
				port = receivePacket.getPort();

				sendData = "From P3 : M Bien reçu".getBytes();
				sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,port);
				serverSocket.send(sendPacket);




				//int x = rmiServer.add(Integer.parseInt(N.trim()), Integer.parseInt(M.trim()));
				//System.out.print("SOMME = "+x);

				System.out.println("SOMME = "+(Integer.parseInt(N)+Integer.parseInt(M)));

				if (amicaux(Integer.parseInt(N),Integer.parseInt(M)))
				{
					System.out.println(N+" et "+M+" sont amicaux");
					System.out.println("P3 : Envoyer les données à P4");
					rmiServer.envoyer(N+" et "+M+" sont amicaux");
				}
				else
				{
					System.out.println(N+" et "+M+" ne sont pas amicaux");
					System.out.println("P3 : Envoyer les données à P4");
					rmiServer.envoyer(N+" et "+M+" sont amicaux");
				}

				rmiServer.mul(Integer.parseInt(N), Integer.parseInt(M));

				rmiServer.cubique((Integer.parseInt(N)+Integer.parseInt(M)));


			}
		}catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());

		}



	}

}