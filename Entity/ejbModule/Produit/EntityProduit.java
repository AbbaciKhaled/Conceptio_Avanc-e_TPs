package Produit;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_Produit")
public class EntityProduit implements Serializable{

	@Id
	private	String id;
	
	@Column(name="libelle_Column")
	private String libelle;
	
	private int quantiteEnStock;

	public EntityProduit(String id, String libelle, int quantiteEnStock) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.quantiteEnStock = quantiteEnStock;
	}

	
	public EntityProduit(String libelle, int quantiteEnStock) {
		super();
		this.libelle = libelle;
		this.quantiteEnStock = quantiteEnStock;
	}


	public EntityProduit(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQuantiteEnStock() {
		return quantiteEnStock;
	}

	public void setQuantiteEnStock(int quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}

	@Override
	public String toString() {
		return "EntityProduit [id=" + id + ", libelle=" + libelle
				+ ", quantiteEnStock=" + quantiteEnStock + "]";
	}
	
	
}
