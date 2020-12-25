import java.io.Serializable;

public class Produit implements Serializable{
	
	private Integer id;
	private String designation;
	private String type;
	private Integer quantite;
	
	
	public Produit (Integer id, String designation, String type, Integer quantite)
	{
		this.id = id;
		this.designation = designation;
		this.type = type;
		this.quantite = quantite;
	}
	
	public Produit (String designation, Integer quantite)
	{
		this.designation = designation;
		this.quantite = quantite;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getQuantite() {
		return quantite;
	}


	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	
	
	
	
}
