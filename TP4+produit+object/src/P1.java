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

				ArrayList a = new ArrayList();


				Scanner scan = new Scanner(System.in);

				System.out.println("Menu :");
				System.out.println("1 - Inserer un produit.");
				System.out.println("2 - Supprimer un produit.");
				System.out.println("3 - Modifier un produit.");
				System.out.println("4 - Rechercher un produit.");
				System.out.println("5 - Afficher un produit.");
				System.out.println("6 - Afficher la liste des produits.");

				a.add(scan.nextInt());



				switch((int) a.get(0)) {

				case 1:
				{
					System.out.println("Donner l'Id du produit : ");
					a.add(scan.next());
					System.out.println("Donner la designation du produit : ");
					a.add(scan.next());
					System.out.println("Donner le type du produit : ");
					a.add(scan.next());
					System.out.println("Donner la quanité du produit : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					System.out.println((String) in.readObject());

					break;
				}	
				case 2:
				{
					System.out.println("Donner l'Id du produit : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println((String) in.readObject());

					break;
				}
				case 3:
				{
					System.out.println("Donner l'Id du produit : ");
					a.add(scan.next());
					
					System.out.println("Donner la nouvele quantié du produit : ");
					a.add(scan.next());
					
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println((String) in.readObject());

					break;
				}
				case 4:
				{
					System.out.println("Donner l'Id du produit : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					
					System.out.println("FROM MYSQL :");
					Produit x = (Produit) in.readObject();
					if (x == null)
						System.out.println("Le produit n'existe pas");
					else
						System.out.println("Le produit existe");

					
					System.out.println("FROM MSACCESS :");
					Produit x2 = (Produit) in.readObject();
					if (x2 == null)
						System.out.println("Le produit n'existe pas");
					else
						System.out.println("Le produit existe");

					
					break;
				}
				case 5:
				{
					System.out.println("Donner l'Id du produit : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					
					System.out.println("FROM MYSQL :");
					Produit x = (Produit) in.readObject();
					if (x == null)
						System.out.println("Aucun produit n'est selectionné");
					else
					{
						System.out.println("Désignation : "+x.getDesignation());
						System.out.println("Qauntité : "+x.getQuantite());
					}
					
					System.out.println("FROM MSACCESS :");
					Produit x2 = (Produit) in.readObject();
					if (x2 == null)
						System.out.println("Aucun produit n'est selectionné");
					else
					{
						System.out.println("Désignation : "+x2.getDesignation());
						System.out.println("Qauntité : "+x2.getQuantite());
					}
					
					break;
				}
				case 6:
				{
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println("FROM MYSQL :");
					ArrayList<Produit> x = (ArrayList<Produit>) in.readObject();
					if (x.size() == 0)
						System.out.println("Aucun produit n'est selectionné");
					else
						for (int i=0;i<x.size();i++)
							System.out.println("Désignation : "+x.get(i).getDesignation() + " | Quantité : "+x.get(i).getQuantite() );

					System.out.println("FROM MSACCESS :");
					ArrayList<Produit> x2 = (ArrayList<Produit>) in.readObject();
					if (x2.size() == 0)
						System.out.println("Aucun produit n'est selectionné");
					else
						for (int i=0;i<x2.size();i++)
							System.out.println("Désignation : "+x2.get(i).getDesignation() + " | Quantité : "+x2.get(i).getQuantite() );

					
					
					break;
				}

				}
			}
		} catch(Exception e){

		}


	}

}
