package br.com.grupo05.trabalho3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.CrudDAO;
import br.com.grupo05.trabalho3.entity.AlunoEntity;
import br.com.grupo05.trabalho3.repository.AlunoRepository;

@Service
@Configurable
public class AlunoDAOImpl implements CrudDAO<AlunoEntity> {
	
	@Autowired
	private AlunoRepository repository;

	@Override
	public void adicionar(AlunoEntity entidade) {
		repository.save(entidade);
	}

	@Override
	public AlunoEntity buscar(Long id) {
		Optional<AlunoEntity> optionalAluno = repository.findById(id);
		if (optionalAluno.isPresent()) {
			return optionalAluno.get();
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		
	}

	@Override
	public void atualizar(AlunoEntity entidade) {
		
	}

	@Override
	public List<AlunoEntity> buscarTodos() {
		return null;
	}

	

}
