package br.edu.unoesc.dao;

import org.springframework.context.annotation.Bean;

public abstract class UsuarioRepository implements UsuarioDao{
	
	private static final UsuarioDao dao = null;

	@Bean(name="dao")
	public static UsuarioDao getDao() {
		return dao;
	}
}
