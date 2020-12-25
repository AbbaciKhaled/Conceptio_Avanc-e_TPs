import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class P3 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI{

	public static Registry registry;
	public static String Adress = "localhost";
	public static int Port=1099;
	
	public static Connection conn = null;
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "master2";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "root";
	public static Statement stmt = null;
	
	
	public static ServerSocket SocketServeur;
	public static Socket connection;
	
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	public static Integer M=0;

	public static Integer S2=0;
	
	protected P3() throws RemoteException {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName, username, password);
			System.out.println("P3 connected to the database");
			stmt = conn.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();

		}
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			P3 s = new P3();	
			registry = LocateRegistry.createRegistry(Port);
			registry.rebind("rmiServer", s);
			
			SocketServeur = new ServerSocket(2004);
			System.out.println("P2 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("P2 : Connection received And Accepted");
			
			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
			
			M = (Integer) in.readObject();
			System.out.println("P2 : Lecture de N");
			out.writeObject("From P2 : Bien reçu");
			
			S2 = (Integer) in.readObject();
			System.out.println("P2 : Lecture de N");
			out.writeObject("From P2 : Bien reçu");
			
			stmt.executeUpdate("Insert into g1 values ("+M+","+S2+");");


			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	@Override
	public void inserer(Integer a, Integer b) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			
			int x=M+a;
			int y=S2+b;
			
			stmt.executeUpdate("Insert into g1 values ("+a+","+b+");");

			stmt.executeUpdate("Insert into g1 values ("+x+","+y+");");


		}catch(Exception e)
		{
			e.printStackTrace();

		}
		
	}

}
