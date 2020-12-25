import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class P4 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI {

	

	public static InterfaceRMI rmiServer;
	public static Registry registry;
	public static String Adress = "127.0.0.1";
	public static int Port = 1100;
	
	static Connection conn = null;
	static String url = "jdbc:ucanaccess://C:\\\\Users\\\\dell\\\\Desktop/dbessai.accdb";
	static String dbName = "master2";
	static String driver = "org.hsqldb.jdbc.JDBCDriver";
	static String username = "";
	static String password = "";
	static Statement stmt = null;

	
	protected P4() throws RemoteException {
		System.out.println("P4 : Adresse Serveur = "+Adress+",Port = "+Port);
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("P4 connected to the database");
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
			P4 s = new P4();
			System.out.println("Server P4 is ready");
			Registry registry = LocateRegistry.createRegistry(Port);
			System.out.println("Created P4 RMI registry on port "+Port);
			registry.rebind("rmiServer", s);
			
			
			
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Integer update(String req) throws RemoteException {
		try {
			int rs = stmt.executeUpdate(req);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public Student select(String req) throws RemoteException {
		try {
			ResultSet rs = stmt.executeQuery(req);
			while (rs.next())
				return new Student (rs.getString("nom"), rs.getString("prenom"));
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public ArrayList<Student> list(String req) throws RemoteException {
		try {
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Student> a = new  ArrayList<Student>();
			while (rs.next())
				a.add(new Student (rs.getString("nom"), rs.getString("prenom")));
			return a;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
