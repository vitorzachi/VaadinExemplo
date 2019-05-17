package br.edu.unoesc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.unoesc.model.TipoSafra;


public interface TipoSafraDao extends JpaRepository<TipoSafra, Long> {
	

}
