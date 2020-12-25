import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class P1 {

	public static Socket SocketClient;
	public static ObjectOutputStream out;
	public static ObjectInputStream in;

	public static void main(String[] args) {

		try {


			SocketClient = new Socket ("localhost",2004);
			System.out.println("P1 : Connected to localhost in port 2004");
			out = new ObjectOutputStream(SocketClient.getOutputStream());
			in = new ObjectInputStream(SocketClient.getInputStream());

			while(true) {

				String a = "";


				Scanner scan = new Scanner(System.in);

				System.out.println("Menu :");
				System.out.println("1 - Inserer un produit.");
				System.out.println("2 - Supprimer un produit.");
				System.out.println("3 - Afficher un produit.");
				System.out.println("4 - Afficher la liste des produits.");


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
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					System.out.println((String) in.readObject());

					break;
				}	
				case 2:
				{
					a+="2,";

					System.out.println("Donner l'id du produit : ");
					a+=scan.next();
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println((String) in.readObject());

					break;
				}
				case 3:
				{
					a+="3,";

					System.out.println("Donner l'id du produit : ");
					a+=scan.next();
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					
					System.out.println("FROM MYSQL :");
					System.out.println((String) in.readObject());
					
					System.out.println("FROM MSACCESS :");
					System.out.println((String) in.readObject());
					
					break;

				}
				case 4:
				{
					a+="4,";

					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println("FROM MYSQL :");
					System.out.println((String) in.readObject());
					
					System.out.println("FROM MSACCESS :");
					System.out.println((String) in.readObject());
					
					
					break;
				}

				}
			}
		} catch(Exception e){

		}


	}

}
