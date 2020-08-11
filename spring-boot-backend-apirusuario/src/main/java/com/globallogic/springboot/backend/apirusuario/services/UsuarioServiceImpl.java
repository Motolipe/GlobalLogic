package com.globallogic.springboot.backend.apirusuario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.springboot.backend.apirusuario.dao.IUsuarioDao;
import com.globallogic.springboot.backend.apirusuario.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findById(String id) {
		
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(String id) {
		
		usuarioDao.deleteById(id);
	}

	@Override
	@Transactional
	public Boolean existsByDscEmail(String email) {
		
		return usuarioDao.existsByEmail(email);
	}

}
