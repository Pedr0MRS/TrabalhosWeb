package control;

import java.util.List;

import model.Celular;

public interface InterfaceCelular {

	public void postCelular(Celular celular);
	
	public String putCelular(Celular celular);
	
	public String delCelular(long id);
	
	public List<Celular> getCelular();
	
	public Celular getCelularId(long id);
	
}
