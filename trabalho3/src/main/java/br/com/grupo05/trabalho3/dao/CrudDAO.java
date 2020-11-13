package br.com.grupo05.trabalho3.dao;

import java.util.List;

public interface CrudDAO<T> {

	public void adicionar(T entidade);
	
	public T buscar(Long id);
	
	public void remover(Long id);
	
	public void atualizar(T entidade);
	
	public List<T> buscarTodos();
}
