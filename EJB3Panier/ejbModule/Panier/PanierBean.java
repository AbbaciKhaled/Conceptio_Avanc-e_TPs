package Panier;

import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class PanierBean implements Panier{

	Vector articles;
	String nomClient;
	
	@PostConstruct
	public void initialise()
	{
		articles = new Vector();
		nomClient = "";
	}
	
	public void ajouterArticle(int idArticle) {
		// TODO Auto-generated method stub
		System.out.println("Ajout d'un nouvel article");
		articles.add(new Integer(idArticle));
	}

	public void supprimerArticle(int idArticle) {
		// TODO Auto-generated method stub
		System.out.println("Quppression d'un article");
		articles.remove(new Integer(idArticle));
	}

	public Vector listArticles() {
		// TODO Auto-generated method stub
		return articles;
	}

	public void setNom(String nomClient) {
		// TODO Auto-generated method stub
		this.nomClient = nomClient;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return nomClient;
	}

	@Remove
	public void remove() {
		// TODO Auto-generated method stub
		articles = null;
	}
	
}
