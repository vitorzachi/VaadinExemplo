package br.edu.unoesc.dao;

import java.util.List;

public interface CrudDao<T> {
	void inserir(T dado);
	void alterar(T dado);
	void remover(Class<T> classe,Long cod);
	List<T> listar(String query, Class<T> classe);
	T buscar(Class<T> classe, Long cod);
}
