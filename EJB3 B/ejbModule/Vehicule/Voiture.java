package Vehicule;
import java.io.Serializable;

public class Voiture implements Serializable{

	public Integer mat;
	public String marq;
	public Integer ann;
	
	public Voiture(Integer mat, String marq, Integer ann)
	{
		this.mat = mat;
		this.marq = marq;
		this.ann = ann;

	}
	
}
