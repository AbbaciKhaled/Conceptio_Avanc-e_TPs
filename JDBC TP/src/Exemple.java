import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemple {
	static Connection conn = null;
	static String url = "jdbc:mysql://localhost:3306/";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(url+"master2","root","root");
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select * from etudiant");
	while(rs.next())
	{
		System.out.println(rs.getString(2));
	}
	}
	
}
