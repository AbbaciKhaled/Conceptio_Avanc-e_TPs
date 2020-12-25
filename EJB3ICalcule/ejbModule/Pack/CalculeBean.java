package Pack;

import javax.ejb.Stateless;

@Stateless
public class CalculeBean implements ICalcule {

	public double add(double val1, double val2) {
		// TODO Auto-generated method stub
		return val1+val2;
	}

	public double mul(double val1, double val2) {
		// TODO Auto-generated method stub
		return val1*val2;
	}

}




