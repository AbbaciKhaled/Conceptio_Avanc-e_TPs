package Produit;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface IEntity {

	public void add(EntityProduit p);
	public EntityProduit find(String id);
	public ArrayList<Object> ListeProduits();
}
