import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class P1 {

	public static DatagramSocket clientSocket;
	public static byte[] receiveData;
	public static byte[] sendData;
	public static DatagramPacket sendPacket;
	public static DatagramPacket receivePacket;
	public static InetAddress IPAddress;
	public static int port ;

	public static void main(String[] args) {

		try {


			clientSocket = new DatagramSocket();
			IPAddress = InetAddress.getByName("localhost");
			port = 9876;

			while(true) {

				String a = "";


				Scanner scan = new Scanner(System.in);

				System.out.println("Menu :");
				System.out.println("1 - Inserer un produit.");
				System.out.println("2 - Supprimer un produit.");
				System.out.println("3 - Rechercher un produit.");
				System.out.println("4 - Modifier un produit.");
				System.out.println("5 - Afficher un produit.");
				System.out.println("6 - Afficher la liste des produits.");



				switch(scan.nextInt()) {

				case 1:
				{
					a+="1,";
					
					System.out.println("Donner l'id du produit : ");
					a+=scan.next()+",";
					System.out.println("Donner la désignation du produit : ");
					a+=scan.next()+",";
					System.out.println("Donner le type du produit : ");
					a+=scan.next()+",";
					System.out.println("Donner la quantité du produit : ");
					a+=scan.next();
					
					
					
					sendData = new byte[1000];
					sendData = a.getBytes();	
					sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
					clientSocket.send(sendPacket);
					System.out.println("Donner envoyées à P2");
					
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
			

					break;
				}	
				case 2:
				{
					a+="2,";

					sendData = new byte[1000];
					sendData = a.getBytes();	
					sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
					clientSocket.send(sendPacket);
					System.out.println("Donner envoyées à P2");
					
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

					break;
				}
				case 3:
				{
					a+="3,";

					System.out.println("Donner l'id du produit : ");
					a+=scan.next();
					sendData = new byte[1000];
					sendData = a.getBytes();	
					sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
					clientSocket.send(sendPacket);
					System.out.println("Donner envoyées à P2");
					
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

				
					System.out.println("FROM MYSQL :");
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
					
					
					System.out.println("FROM MSACCESS :");
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
					
					
					break;

				}
				case 4:
				{
					a+="4,";

					System.out.println("Donner l'id du produit : ");
					a+=scan.next()+",";
					System.out.println("Donner la quantité du produit : ");
					a+=scan.next();

					sendData = new byte[1000];
					sendData = a.getBytes();	
					sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
					clientSocket.send(sendPacket);
					System.out.println("Donner envoyées à P2");
					
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

					break;
				}

				case 5:
				{
					a+="5,";

					System.out.println("Donner l'id du produit : ");
					a+=scan.next();
					sendData = new byte[1000];
					receiveData = new byte[1000];
					sendData = a.getBytes();	
					sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
					clientSocket.send(sendPacket);
					System.out.println("Donner envoyées à P2");
					
					receiveData = new byte[1000];
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

				
					System.out.println("FROM MYSQL :");
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
					
					receiveData = new byte[1000];
					System.out.println("FROM MSACCESS :");
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
					
					break;

				}
				case 6:
				{
					a+="6,";

					sendData = new byte[1000];
					sendData = a.getBytes();	
					sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
					clientSocket.send(sendPacket);
					System.out.println("Donner envoyées à P2");
					
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));

				
					System.out.println("FROM MYSQL :");
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
					
					
					System.out.println("FROM MSACCESS :");
					receiveData = new byte[1000];
					receivePacket = new DatagramPacket(receiveData,receiveData.length);
					clientSocket.receive(receivePacket);
					System.out.println(new String(receivePacket.getData()));
					
					
					break;
				}

				}
			}
		} catch(Exception e){

		}


	}

}
