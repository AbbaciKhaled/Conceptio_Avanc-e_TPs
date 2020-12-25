import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import Vehicule.Voiture;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfaceRMI rmiServer;
		Registry registry;
		String Adress = "127.0.0.1";
		Integer Port = 2010;
		String text = "Hello from client";
		System.out.println("sending from client >>> "+" to "+Adress+":"+Port);
		
		try {

			registry = LocateRegistry.getRegistry("127.0.0.1",Port);
			System.out.println("RMI Registry found on port"+Port);
			rmiServer = (InterfaceRMI) (registry.lookup("rmiServer"));
			
			while (true)
			{

				//lire N et envoyer a C2

				ArrayList data = new ArrayList<String>();

				Scanner scan = new Scanner(System.in);				
				System.out.println("Choisr une opération : ");
				System.out.println("1 - Inserer un véhicule");
				System.out.println("2 - Supprimer un véhicule");
				System.out.println("3 - Afficher un véhicule");
				data.add(scan.nextInt());

				System.out.println("Taper le matricule du véhicule : ");
				data.add(scan.nextInt());			

				switch((Integer) data.get(0))
				{
				case 1 :
				{
					System.out.println("Taper la marque du véhicule : ");
					data.add(scan.next());			
					System.out.println("Taper l'année du véhicule : ");
					data.add(scan.nextInt());			
					System.out.println((String) rmiServer.traitement(data));
					break;
				}
				case 2 :
				{
					System.out.println((String) rmiServer.traitement(data));				
					break;
				}
				case 3 :
				{
					
					Voiture v = (Voiture) rmiServer.traitement(data);
					
					
					System.out.println("Result:");
					if (v != null )
					{
						System.out.println("	Matricule : " + v.mat);
						System.out.println("	Marque : " + v.marq);
						System.out.println("	Année : " + v.ann);
					}
					else
					{
						System.out.println("	Aucune ligne sélectionnée");
					}
					break;
				}
				default : break;
				}

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
