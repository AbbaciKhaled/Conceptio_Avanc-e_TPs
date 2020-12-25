package Calcule;

import javax.ejb.Stateless;

@Stateless
public class CalculeBean implements Calcule {

	public int Add(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	public int Mul(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	public int Div(int x, int y) {
		// TODO Auto-generated method stub
		return x/y;
	}

}
