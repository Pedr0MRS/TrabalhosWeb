package control;

import java.util.ArrayList;
import java.util.List;

import model.Capinha;

public class ControleCapinha implements InterfaceCapinha {

	private List<Capinha> capinhas = new ArrayList<Capinha>();
	private long idCapinha;

	// CRUD Capinha
	@Override
	public void postCapinha(Capinha capinha) {
		idCapinha++;
		capinha.setId(idCapinha);
		capinhas.add(capinha);
	}

	@Override
	public String putCapinha(Capinha capinha) {
		try {
			int index = buscarCapinha(capinha.getId());
			capinhas.set(index, capinha);
			return "Alterado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Capinha> getCapinha() {
		return capinhas;
	}

	@Override
	public Capinha getCapinhaId(long id) {
		try {
			int posi = buscarCapinha(id);
			return capinhas.get(posi);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String delCapinha(long id) {
		try {
			int posic = buscarCapinha(id);
			capinhas.remove(posic);
			return "Capinha excluida com sucesso!";
		} catch (Exception e) {
			return "Capinha não encontrada";
		}
	}

	private int buscarCapinha(long id) throws Exception {
		for (int i = 0; i < capinhas.size(); i++) {
			if (capinhas.get(i).getId() == id) {
				return i;
			}
		}
		throw new Exception("Capinha não encontrada!");
	}

}
