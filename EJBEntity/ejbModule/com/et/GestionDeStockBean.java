package com.et;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Calcule.Calcule;
@Stateless
public class GestionDeStockBean implements GestionDeStock{

	@PersistenceContext
	EntityManager em;
	
	public void ajouter(Produit produit) {
		// TODO Auto-generated method stub
		em.persist(produit);
	}

	public Produit rechercherProduit(String id) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, id);
	}

	public List<Produit> listerTousLesProduits() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT p FROM Produit p ORDER BY p.quantiteEnStock").getResultList();
	}

	public void Communiquer() {
		// TODO Auto-generated method stub
		try {
			Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
			Context ctx = new InitialContext(props);
			Calcule op = (Calcule) ctx.lookup("CalculeBean/remote");
			
			System.out.println("X + Y = "+op.Add(8, 4));
			System.out.println("X * Y = "+op.Mul(8, 4));
			System.out.println("X / Y = "+op.Div(8, 4));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
