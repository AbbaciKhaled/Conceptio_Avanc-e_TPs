import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P2 {


	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	public static ServerSocket SocketServeur;
	public static Socket connection;
	
	
	public static DatagramSocket clientSocket;
	public static byte[] receiveData;
	public static byte[] sendData;
	public static DatagramPacket sendPacket;
	public static DatagramPacket receivePacket;
	public static InetAddress IPAddress;
	public static int port ;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			SocketServeur = new ServerSocket(2004);
			System.out.println("P2 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("P2 : Connection received And Accepted");
			
			
			clientSocket = new DatagramSocket();
			IPAddress = InetAddress.getByName("localhost");
			port = 9876;
			
			while(true)
			{
				
				//Lire N	
				in = new ObjectInputStream(connection.getInputStream());
				String N = (String) in.readObject();
				System.out.println("P2 : Lecture de N");
				out = new ObjectOutputStream(connection.getOutputStream());
				out.writeObject("From P2 : Bien reçu");
				
				Scanner scan = new Scanner(System.in);
				System.out.println("Donner M : ");
				String M = scan.next();
	
				
				sendData = new byte[50];
				receiveData = new byte[50];
				sendData = N.getBytes();	
				sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
				clientSocket.send(sendPacket);
				System.out.println("P2 : N = "+N+" envoyée à P3");
				
				receivePacket = new DatagramPacket(receiveData,receiveData.length);
				clientSocket.receive(receivePacket);
				System.out.println(new String(receivePacket.getData()));
				

				sendData = new byte[50];
				receiveData = new byte[50];
				
				sendData = M.getBytes();
				sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
				clientSocket.send(sendPacket);
				System.out.println("P2 : M = "+M+" envoyée à P3");
				
				receivePacket = new DatagramPacket(receiveData,receiveData.length);
				clientSocket.receive(receivePacket);
				System.out.println(new String(receivePacket.getData()));
				
			}
			
			
		}catch(Exception e)
		{
			System.out.println("Exception !!! "+e.toString());
		}

	}
	
}
