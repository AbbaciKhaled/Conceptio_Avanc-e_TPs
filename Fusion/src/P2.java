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
	

	public static ServerSocket SocketServeur2;
	public static Socket connection2;
	
	
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
			
			SocketServeur2 = new ServerSocket(7000);
			System.out.println("C2 : Waiting for connection P0");
			connection2 = SocketServeur2.accept();
			System.out.println("C2 : Connection received And Accepted P0");
			
			while(true)
			{
				
				//Lire N
				out = new ObjectOutputStream(connection.getOutputStream());
				in = new ObjectInputStream(connection.getInputStream());
				String N = (String) in.readObject();
				System.out.println("P2 : Lecture de N");
				out.writeObject("From P2 : Bien reçu");
				
				//lire M
				out = new ObjectOutputStream(connection2.getOutputStream());
				in = new ObjectInputStream(connection2.getInputStream());
				String M = (String) in.readObject();
				out.writeObject("Bien reçu from P2");
	
				
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
