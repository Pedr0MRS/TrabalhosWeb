package br.com.grupo05.trabalho3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class DisciplinaEntity {

	@Id
	@GeneratedValue
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="orientador", nullable = false)
	private String orientador;
	
	@Column(name="creditos", nullable = false)
	private int creditos;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<AlunoEntity> alunos = new ArrayList<>();

	public DisciplinaEntity(Long id, String nome, String orientador, int creditos) {
		super();
		this.id = id;
		this.nome = nome;
		this.orientador = orientador;
		this.creditos = creditos;
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

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunos;
	}
	
}
