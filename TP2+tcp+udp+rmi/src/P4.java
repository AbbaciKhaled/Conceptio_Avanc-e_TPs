import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class P4 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI {

	public static Registry registry;
	public static String Adress = "localhost";
	public static int Port=1099;
	
	public static InterfaceRMI2 rmiServer2;
	public static Registry registry2;
	public static String Adress2 = "127.0.0.1";
	public static int Port2 = 1100;



	protected P4() throws RemoteException {
		System.out.println("P4 : Adresse Serveur = "+Adress+",Port = "+Port);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {

			P4 s = new P4();	
			registry = LocateRegistry.createRegistry(Port);
			registry.rebind("rmiServer", s);
			
			registry2 = LocateRegistry.getRegistry("127.0.0.1",1100);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	@Override
	public void mul(int a, int b) throws RemoteException {
		System.out.println("P4 : La méthode produit est invoquée");
		System.out.println("PRODUIT = "+(a*b));
	}

	@Override
	public void cubique(int a) throws RemoteException {
		try {

			System.out.println("P4 : La méthode cubique est invoquée");

			rmiServer2 = (InterfaceRMI2) (registry2.lookup("rmiServer2"));


			ArrayList<Integer> ar = new ArrayList<Integer>();

			for (int i=1; i<a; i++)
			{
				if(Integer.toString(i).length()==3)
						if (Math.pow(i%10, 3)+Math.pow((i/10)%10, 3)+Math.pow((i/100)%10, 3)==i)
							ar.add(i);
			}
			
			if (!ar.isEmpty())
			{
				System.out.println("Les nombres cubiques : "+ar);
				rmiServer2.afficherCubique(ar);
			}
			else
			{
				System.out.println("Aucun nombre cubique inferieur à la somme");
				rmiServer2.afficher("Aucun nombre cubique inferieur à la somme");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	@Override
	public void envoyer(String a) throws RemoteException {
		// TODO Auto-generated method stub
		try {

			System.out.println("P4 : La méthode envoyer à P1 est invoquée");

			rmiServer2 = (InterfaceRMI2) (registry2.lookup("rmiServer2"));
			rmiServer2.afficher(a);
		}
		catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());
		}

	}


	/*@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a+b;
	}*/


}
