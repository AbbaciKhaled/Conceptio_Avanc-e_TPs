package com.et;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GestionDeStock {
	public void ajouter(Produit produit);
	public Produit rechercherProduit(String id);
	public List<Produit> listerTousLesProduits();
	void Communiquer();
}

