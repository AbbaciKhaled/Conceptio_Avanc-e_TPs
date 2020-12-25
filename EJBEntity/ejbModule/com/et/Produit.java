package com.et;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_produit")
public class Produit implements Serializable {
	@Id
	private String id;
	@Column(name="libelle_Column")
	private String libelle;
	private int quantiteEnStock;
	
	public Produit() {super();}
	public Produit(String id) {this.id = id;}
	public Produit(String id, String libelle, int quantiteEnStock) {
		this.id = id;
		this.libelle = libelle;
		this.quantiteEnStock = quantiteEnStock;
	}
	
	public String getLibelle() {
		return libelle;}
	public void setLibelle(String libelle) {
		this.libelle = libelle;}
	
	public int getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(int quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	
	public String getId() {
		return id;
	}

	public String toString() {
		return "Produit n° " + id + " - " + libelle + " - quantité disponible : " + quantiteEnStock;
	}
}
