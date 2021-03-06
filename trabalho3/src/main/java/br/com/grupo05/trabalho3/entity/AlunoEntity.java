package br.com.grupo05.trabalho3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "aluno")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AlunoEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@SequenceGenerator(name="aluno_id_seq")
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="matricula", nullable = false)
	private String matricula;
	
	@Column(name="curso", nullable = false)
	private String curso;
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "aluno_disciplina",
	           joinColumns = { @JoinColumn(name = "aluno_id")},
			   inverseJoinColumns = {@JoinColumn(name = "disciplina_id")})
	private List<DisciplinaEntity> disciplinas = new ArrayList<>();

	public AlunoEntity() {
		
	}
	
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
	
	public void adicionarDisciplina(DisciplinaEntity disciplina) {
		disciplinas.add(disciplina);
		disciplina.getAlunos().add(this);
	}
	
	public void removerDisciplina(DisciplinaEntity disciplina) {
		disciplinas.remove(disciplina);
		disciplina.getAlunos().remove(this);
	}
	
}
