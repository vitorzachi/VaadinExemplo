package br.edu.unoesc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
