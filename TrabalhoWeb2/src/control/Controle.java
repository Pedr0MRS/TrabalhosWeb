package control;

import java.util.List;

import javax.jws.WebService;

import model.Capinha;
import model.Celular;

@WebService(endpointInterface="control.ControleInterface")
public class Controle implements ControleInterface {

	private List<Celular> celulares;
	private List<Capinha> capinhas;
	
	// CRUD Celular
	@Override
	public void postCelular(String xmlCelular) {

		System.out.println("Entrou aqui!");
		
	}

	@Override
	public void putCelular(String xmlCelular) {
		
	}

	@Override
	public String getCelular() {
		return "Retorno!";
	}

	@Override
	public String getCelularId(long id) {
		return "";
	}

	@Override
	public String delCelular(long id) {
		return "";
	}

	// CRUD Capinha
	@Override
	public void postCapinha(String xmlCapinha) {

	}

	@Override
	public void putCapinha(String xmlCapinha) {

	}

	@Override
	public String getCapinha() {
		return "";
	}

	@Override
	public String getCapinhaId(long id) {
		return "";
	}

	@Override
	public String delCapinha(long id) {
		return "";
	}

}
