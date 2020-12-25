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
				System.out.println("1 - Inserer un étudiant.");
				System.out.println("2 - Supprimer un étudiant.");
				System.out.println("3 - Afficher un étudiant.");
				System.out.println("4 - Afficher la liste des étudiants.");

				a.add(scan.nextInt());



				switch((int) a.get(0)) {

				case 1:
				{
					System.out.println("Donner le matricule de l'étudaint : ");
					a.add(scan.next());
					System.out.println("Donner le nom de l'étudaint : ");
					a.add(scan.next());
					System.out.println("Donner le prénom de l'étudaint : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					System.out.println((String) in.readObject());

					break;
				}	
				case 2:
				{
					System.out.println("Donner le matricule de l'étudaint : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println((String) in.readObject());

					break;
				}
				case 3:
				{
					System.out.println("Donner le matricule de l'étudaint : ");
					a.add(scan.next());
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());
					
					System.out.println("FROM MYSQL :");
					Student x = (Student) in.readObject();
					if (x == null)
						System.out.println("Aucun étudiant n'est selectionné");
					else
					{
						System.out.println("Nom : "+x.getNom());
						System.out.println("Prenom : "+x.getPrenom());
					}
					
					System.out.println("FROM MSACCESS :");
					Student x2 = (Student) in.readObject();
					if (x2 == null)
						System.out.println("Aucun étudiant n'est selectionné");
					else
					{
						System.out.println("Nom : "+x2.getNom());
						System.out.println("Prenom : "+x2.getPrenom());
					}
					break;
				}
				case 4:
				{
					out.writeObject(a);
					System.out.println("Donner envoyées à P2");
					System.out.println((String) in.readObject());

					System.out.println("FROM MYSQL :");
					ArrayList<Student> x = (ArrayList<Student>) in.readObject();
					if (x.size() == 0)
						System.out.println("Aucun étudiant n'est selectionné");
					else
						for (int i=0;i<x.size();i++)
							System.out.println("Nom : "+x.get(i).getNom() + " | Prénom : "+x.get(i).getPrenom() );

					System.out.println("FROM MSACCESS :");
					ArrayList<Student> x2 = (ArrayList<Student>) in.readObject();
					if (x2.size() == 0)
						System.out.println("Aucun étudiant n'est selectionné");
					else
						for (int i=0;i<x2.size();i++)
							System.out.println("Nom : "+x2.get(i).getNom() + " | Prénom : "+x2.get(i).getPrenom() );

					
					
					break;
				}

				}
			}
		} catch(Exception e){

		}


	}

}
