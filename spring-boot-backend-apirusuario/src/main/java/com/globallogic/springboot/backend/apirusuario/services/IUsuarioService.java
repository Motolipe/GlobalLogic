package com.globallogic.springboot.backend.apirusuario.services;

import java.util.List;

import com.globallogic.springboot.backend.apirusuario.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario findById(String id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(String id);
	
	public Boolean existsByDscEmail(String email);
}
