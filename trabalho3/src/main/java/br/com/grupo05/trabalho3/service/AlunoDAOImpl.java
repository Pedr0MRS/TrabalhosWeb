package br.com.grupo05.trabalho3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.CrudDAO;
import br.com.grupo05.trabalho3.entity.AlunoEntity;
import br.com.grupo05.trabalho3.entity.DisciplinaEntity;
import br.com.grupo05.trabalho3.repository.AlunoRepository;

@Service
@Configurable
public class AlunoDAOImpl implements CrudDAO<AlunoEntity> {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private DisciplinaDAOImpl disciplinaDAO;

	@Override
	public void adicionar(AlunoEntity entidade) {
		repository.save(entidade);
	}

	@Override
	public AlunoEntity buscar(Long id) {
		Optional<AlunoEntity> aluno = repository.findById(id);
		if (aluno.isPresent()) {
			return aluno.get();
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void atualizar(AlunoEntity entidade) {
		repository.save(entidade);
	}

	@Override
	public List<AlunoEntity> buscarTodos() {
		return (List<AlunoEntity>) repository.findAll();
	}

	public void adicionarDisciplina(Long idAluno, Long idDisciplina) {
		AlunoEntity aluno = buscar(idAluno);
		DisciplinaEntity disciplina = disciplinaDAO.buscar(idDisciplina);
		aluno.adicionarDisciplina(disciplina);
		atualizar(aluno);
	}
	
	public void removerDisciplina(Long idAluno, Long idDisciplina) {
		AlunoEntity aluno = buscar(idAluno);
		DisciplinaEntity disciplina = disciplinaDAO.buscar(idDisciplina);
		aluno.removerDisciplina(disciplina);
		atualizar(aluno);
	}
	
	public AlunoEntity buscarAlunoPorNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public AlunoEntity buscarAlunoPorCurso(String curso) {
		return repository.findByCurso(curso);
	}

}
