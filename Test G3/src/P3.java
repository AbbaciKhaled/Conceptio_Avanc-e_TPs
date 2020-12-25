import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P3  extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI {

	public static Connection conn = null;
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "master2";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "root";
	public static Statement stmt = null;
	
	public static Registry registry;
	public static String Adress = "localhost";
	public static int Port=1099;
	
	
	public static ObjectOutputStream out;
	public static ObjectInputStream in;
	
	public static ServerSocket SocketServeur;
	public static Socket connection;
	
	
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
			registry = LocateRegistry.createRegistry(1099);
			registry.rebind("rmiServer", s);
			
			SocketServeur = new ServerSocket(2004);
			System.out.println("P2 : Waiting for connection");
			connection = SocketServeur.accept();
			System.out.println("P2 : Connection received And Accepted");
			
			
			String M = (String) in.readObject();
			System.out.println("P2 : Lecture de N");
			out.writeObject("From P2 : Bien reçu");
			
			String S2 = (String) in.readObject();
			System.out.println("P2 : Lecture de N");
			out.writeObject("From P2 : Bien reçu");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public int inserer(Integer a) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			a=a*3;

			stmt.executeUpdate("Insert into g3 values (9,"+a+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
