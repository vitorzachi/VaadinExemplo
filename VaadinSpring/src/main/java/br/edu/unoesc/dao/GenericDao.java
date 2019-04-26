package br.edu.unoesc.dao;
 
import java.util.List;

import br.edu.unoesc.util.Conexao;

public abstract class GenericDao<T> extends Conexao implements CrudDao<T> {

	@Override
	public void inserir(T dado) {
		conectar();
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(dado);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			desconectar();
		}

	}

	@Override
	public T buscar(Class<T> classe, Long cod) {
		conectar();
		try {
			return em.find(classe, cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			desconectar();
		}
	}

	@Override
	public List<T> listar(String query, Class<T> classe) {
		conectar();
		try {
			return em.createNamedQuery(query, classe).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			desconectar();
		}
	}

	@Override
	public void alterar(T dado) {
		conectar();
		try {
			et = em.getTransaction();
			et.begin();
			em.merge(dado);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			desconectar();
		}
	}

	@Override
	public void remover(Class<T> classe, Long cod) {
		conectar();
		try {
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(classe, cod));
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			desconectar();
		}
	}

}
