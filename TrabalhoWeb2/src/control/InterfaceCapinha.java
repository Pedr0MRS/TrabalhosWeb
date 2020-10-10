package control;

import java.util.List;

import model.Capinha;

public interface InterfaceCapinha {

	public void postCapinha(Capinha capinha);

	public String putCapinha(Capinha capinha);

	public List<Capinha> getCapinha();

	public Capinha getCapinhaId(long id);

	public String delCapinha(long id);

}
