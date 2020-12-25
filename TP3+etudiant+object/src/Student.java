import java.io.Serializable;

public class Student implements Serializable{
	
	private Integer mat;
	private String nom;
	private String prenom;
	
	public Student (String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Integer getMat() {
		return mat;
	}
	public void setMat(Integer mat) {
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}
