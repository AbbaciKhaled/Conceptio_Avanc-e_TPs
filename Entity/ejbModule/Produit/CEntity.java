package Produit;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CEntity implements IEntity{

	@PersistenceContext
	EntityManager em;
	
	public void add(EntityProduit p) {
		// TODO Auto-generated method stub
		em.persist(p);
		System.out.println("success");
	}

	public EntityProduit find(String id) {
		// TODO Auto-generated method stub
		return em.find(EntityProduit.class, id);
	}

	public ArrayList<Object> ListeProduits() {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) em.createQuery("Select p from EntityProduit p").getResultList();
	}

}
