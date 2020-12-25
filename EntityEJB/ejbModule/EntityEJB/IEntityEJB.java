package EntityEJB;

import java.util.ArrayList;

import javax.ejb.Remote;


@Remote
public interface IEntityEJB {

	public ArrayList<Object> Connection(int choix,String id,String lib,int qt);
	
	public void Connection1();
}
