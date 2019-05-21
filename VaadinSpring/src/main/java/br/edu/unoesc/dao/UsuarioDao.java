package br.edu.unoesc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	
	void findByNome(String nome);
	
}
