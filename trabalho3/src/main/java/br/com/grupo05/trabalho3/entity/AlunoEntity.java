package br.com.grupo05.trabalho3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class AlunoEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="matricula", nullable = false)
	private String matricula;
	
	@Column(name="curso", nullable = false)
	private String curso;
	
	@ManyToMany
	@JoinTable(name = "aluno_disciplina",
	           joinColumns = { @JoinColumn(name = "aluno_id")},
			   inverseJoinColumns = {@JoinColumn(name = "disciplina_id")})
	private List<DisciplinaEntity> disciplinas = new ArrayList<>();

	public AlunoEntity(Long id, String nome, String matricula, String curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<DisciplinaEntity> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaEntity> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
