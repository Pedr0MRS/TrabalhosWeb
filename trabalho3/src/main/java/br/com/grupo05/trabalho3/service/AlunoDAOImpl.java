package br.com.grupo05.trabalho3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.CrudDAO;
import br.com.grupo05.trabalho3.entity.AlunoEntity;
import br.com.grupo05.trabalho3.entity.DisciplinaEntity;
import br.com.grupo05.trabalho3.error.BadRequestException;
import br.com.grupo05.trabalho3.error.ResourceNotFoundException;
import br.com.grupo05.trabalho3.repository.AlunoRepository;

@Service
public class AlunoDAOImpl implements CrudDAO<AlunoEntity> {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private DisciplinaDAOImpl disciplinaDAO;

	@Override
	public void adicionar(AlunoEntity entidade) {
		validaCamposAluno(entidade);
		repository.save(entidade);
	}

	@Override
	public AlunoEntity buscar(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado aluno com id=" + id));
	}

	@Override
	public void remover(Long id) {
		buscar(id);
		repository.deleteById(id);
	}

	@Override
	public void atualizar(AlunoEntity entidade) {
		buscar(entidade.getId());
		validaCamposAluno(entidade);
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
	
	public List<AlunoEntity> buscarAlunosPorNome(String nome) {
		return repository.findByNomeContaining(nome);
	}
	
	public List<AlunoEntity> buscarAlunosPorCurso(String curso) {
		return repository.findByCursoContaining(curso);
	}
	
	private void validaCamposAluno(AlunoEntity aluno) {
		if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
			throw new BadRequestException("É necessário preencher campo nome");
		}
		if (aluno.getCurso() == null || aluno.getCurso().isEmpty() ) {
			throw new BadRequestException("É necessário preencher campo curso");
		}
		if (aluno.getMatricula() == null || aluno.getMatricula().isEmpty() ) {
			throw new BadRequestException("É necessário preencher campo matrícula");
		}
		if (aluno.getNome().length() > 100) {
			throw new BadRequestException("O número máximo de caracteres do campo nome é (100)");
		}
		if (aluno.getMatricula().length() > 30) {
			throw new BadRequestException("O número máximo de caracteres do campo matrícula é (30)");
		}
		if (aluno.getCurso().length() > 50) {
			throw new BadRequestException("O número máximo de caracteres do campo curso é (50)");
		}
		if (!soTemNumeros(aluno.getMatricula())) {
			throw new BadRequestException("Só pode conter números no campo matrícula");
		}
		AlunoEntity alunoByMatricula = repository.findByMatricula(aluno.getMatricula());
		if (alunoByMatricula != null && alunoByMatricula.getId() != aluno.getId()) {
			throw new BadRequestException("Já existe aluno com essa matrícula");
		}
	}
	
	
	public boolean soTemNumeros(String texto) { 
		for (int i = 0; i < texto.length(); i++) { 
			if (!Character.isDigit(texto.charAt(i))) { 
				return false; 
			} 
		} 
		return true; 
	}
}
