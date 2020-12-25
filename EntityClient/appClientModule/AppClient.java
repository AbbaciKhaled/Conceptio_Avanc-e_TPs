import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;

import EntityEJB.IEntityEJB;



public class AppClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object>p=new ArrayList<Object>();
		try{
			Properties props=System.getProperties();
			
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			
			Context ctx =new InitialContext(props);
			
			IEntityEJB produit= (IEntityEJB ) ctx.lookup("CEntityEJB/remote");
			
			produit.Connection1();
			
			System.out.println("1-Insertion");
			System.out.println("2-Recherche");
			System.out.println("3-Affichage");
			System.out.println("Entre votre choix");
			Scanner sc= new Scanner(System.in);
			int choix2 = sc.nextInt();
			
			switch(choix2){
			case 1:{
				System.out.println("Entre l'id ");
				String id=sc.next();
				System.out.println("Entre libelle");
				String libelle=sc.next();
				System.out.println("Entre quantiteEnStock");
				int quantiteEnStock=sc.nextInt();
				
				produit.Connection(choix2,id,libelle,quantiteEnStock);
			}
			break;
			case 2:{
				System.out.println("Entre l'id a recherche");
				String id=sc.next();
				p= produit.Connection(choix2,id,"",0);
			}
			break;
			case 3:{
				p= produit.Connection(choix2,"","", 0);
				
				
			}
			break;
			}
			for(int i=0;i<p.size();i++){
			System.out.println(p.get(i));	
		}
			
		}
		catch(Exception e){
			e.getStackTrace();
		}

	}

}
