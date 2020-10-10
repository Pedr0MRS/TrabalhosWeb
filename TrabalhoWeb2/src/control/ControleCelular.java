package control;

import java.util.ArrayList;
import java.util.List;

import model.Celular;

public class ControleCelular implements InterfaceCelular {
	private List<Celular> celulares = new ArrayList<Celular>();
	private long idCelular;

	// CRUD Celular
	@Override
	public void postCelular(Celular celular) {
		idCelular++;
		celular.setId(idCelular);
		celulares.add(celular);
	}

	@Override
	public String putCelular(Celular celular) {
		try {
			int index = buscarCelular(celular.getId());
			celulares.set(index, celular);
			return "Alterado com sucesso";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Celular> getCelular() {
		return celulares;
	}

	@Override
	public Celular getCelularId(long id) {
		try {
			int posi = buscarCelular(id);
			return celulares.get(posi);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String delCelular(long id) {
		try {
			int posi = buscarCelular(id);
			celulares.remove(posi);
			return "Celular removido com sucesso!";
		} catch (Exception e) {
			return "Celular não encontrado!";
		}
	}

	private int buscarCelular(long id) throws Exception {
		for (int i = 0; i < celulares.size(); i++) {
			if (celulares.get(i).getId() == id) {
				return i;
			}
		}
		throw new Exception("Celular não encontrado!");
	}
}
