import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P1 {

	public static DatagramSocket clientSocket;
	public static byte[] receiveData;
	public static byte[] sendData;
	public static DatagramPacket sendPacket;
	public static DatagramPacket receivePacket;
	public static InetAddress IPAddress;
	public static int port ;
	
	public static Connection conn = null;
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "master2";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "root";
	public static Statement stmt = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			clientSocket = new DatagramSocket();
			IPAddress = InetAddress.getByName("localhost");
			port = 9876;
			
			
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName, username, password);
			System.out.println("P3 connected to the database");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select num from g3 where id=1");
			String x="";  
			
			if (rs.next())
				x = Integer.toString(rs.getInt("num")); 
			
			
			sendData = new byte[50];
			receiveData = new byte[50];
			sendData = x.getBytes();	
			sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
			clientSocket.send(sendPacket);
			System.out.println("P2 : N = "+x+" envoyée à P3");
			
			receivePacket = new DatagramPacket(receiveData,receiveData.length);
			clientSocket.receive(receivePacket);
			System.out.println(new String(receivePacket.getData()));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
