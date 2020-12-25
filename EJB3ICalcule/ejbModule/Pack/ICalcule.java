package Pack;

import javax.ejb.Remote;

@Remote
public interface ICalcule {
	public double add(double val1, double val2) throws Exception;
	public double mul(double val1, double val2) throws Exception;
}