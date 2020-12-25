package Vehicule;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Stateless;

@Stateless
public class VéhiculeBean implements Vehicule {

	
	static Connection conn = null;
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "master2";
	static String driver = "com.mysql.jdbc.Driver";
	static String username = "root";
	static String password = "root";
	static Statement stmt = null;
	
	
	static Connection conn2 = null;
	static String url2 = "jdbc:ucanaccess://C:\\\\Users\\\\dell\\\\Desktop/dbessai.accdb";
	static String dbName2 = "master2";
	static String driver2 = "org.hsqldb.jdbc.JDBCDriver";
	static String username2 = "root";
	static String password2 = "root";
	static Statement stmt2 = null;
	
	
	public void connexion() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName, username, password);
			System.out.println("P3 connected to the database");
			stmt = conn.createStatement();
			
			Class.forName(driver2).newInstance();
			conn2 = DriverManager.getConnection(url2,"","");
			System.out.println("P4 connected to the database");
			stmt2 = conn2.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public String insertion(String req) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			
			connexion();
			
			
			int rs = stmt.executeUpdate(req);
			int rs2 = stmt2.executeUpdate(req);

			if (rs==1 && rs2==1)
				return "Insertion terminée avec succès";
			else if(rs==0 && rs2==0)
				return "Insertion échouée dans les 2 bases";
			else if(rs==0)
				return "Insertion échouée dans la base MySQL";
			else
				return "Insertion échouée dans la base MS Access";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	public String suppression(String req) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			
			
			connexion();

			
			int rs = stmt.executeUpdate(req);
			int rs2 = stmt2.executeUpdate(req);

			if (rs==1 && rs2==1)
				return "Suppression terminée avec succès";
			else if(rs==0 && rs2==0)
				return "Suppression échouée dans les 2 bases";
			else if(rs==0)
				return "Suppression échouée dans la base MySQL";
			else
				return "Suppression échouée dans la base MS Access";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Voiture oneSelect(String req) throws RemoteException {
		try {
			
			connexion();			
			
			ResultSet rs = stmt.executeQuery(req);
			ResultSet rs2 = stmt2.executeQuery(req);

			Voiture e = null;
			while (rs.next())
				return new Voiture (rs.getInt("Matricule"), rs.getString("Marque"), rs.getInt("Annee"));
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}


	}

}
