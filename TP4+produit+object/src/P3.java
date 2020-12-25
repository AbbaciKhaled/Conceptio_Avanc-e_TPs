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

public class P3 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI {

	

	public static InterfaceRMI rmiServer;
	public static Registry registry;
	public static String Adress = "127.0.0.1";
	public static int Port = 1099;
	
	public static Connection conn = null;
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "master2";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "root";
	public static Statement stmt = null;

	
	protected P3() throws RemoteException {
		System.out.println("P3 : Adresse Serveur = "+Adress+",Port = "+Port);
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
			System.out.println("Server P3 is ready");
			Registry registry = LocateRegistry.createRegistry(Port);
			System.out.println("Created P3 RMI registry on port "+Port);
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
	public Produit select(String req) throws RemoteException {
		try {
			ResultSet rs = stmt.executeQuery(req);
			while (rs.next())
				return new Produit (rs.getString("designation"), rs.getInt("quantite"));
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public ArrayList<Produit> list(String req) throws RemoteException {
		try {
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Produit> a = new  ArrayList<Produit>();
			while (rs.next())
				a.add(new Produit (rs.getString("designation"), rs.getInt("quantite")));
			return a;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
