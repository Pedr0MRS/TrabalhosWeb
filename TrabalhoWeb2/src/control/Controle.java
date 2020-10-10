package control;

import java.util.List;

import javax.jws.WebService;

import model.Celular;
import model.Capinha;

@WebService(endpointInterface = "control.InterfaceControle")
public class Controle implements InterfaceControle {

	private ControleCelular controleCelular = new ControleCelular();
	private ControleCapinha controleCapinha = new ControleCapinha();

	@Override
	public void postCelular(Celular celular) {
		controleCelular.postCelular(celular);
	}

	@Override
	public String putCelular(Celular celular) {
		return controleCelular.putCelular(celular);
	}

	@Override
	public List<Celular> getCelular() {
		return controleCelular.getCelular();
	}

	@Override
	public Celular getCelularId(long id) {
		return controleCelular.getCelularId(id);
	}

	@Override
	public String delCelular(long id) {
		return controleCelular.delCelular(id);
	}

	@Override
	public void postCapinha(Capinha capinha) {
		controleCapinha.postCapinha(capinha);
	}

	@Override
	public String putCapinha(Capinha capinha) {
		return controleCapinha.putCapinha(capinha);
	}

	@Override
	public List<Capinha> getCapinha() {
		return controleCapinha.getCapinha();
	}

	@Override
	public Capinha getCapinhaId(long id) {
		return controleCapinha.getCapinhaId(id);
	}

	@Override
	public String delCapinha(long id) {
		return controleCapinha.delCapinha(id);
	}

}
