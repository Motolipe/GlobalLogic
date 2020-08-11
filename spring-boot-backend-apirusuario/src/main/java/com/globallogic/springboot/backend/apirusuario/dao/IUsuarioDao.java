package com.globallogic.springboot.backend.apirusuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.springboot.backend.apirusuario.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, String> {

	
	Boolean existsByEmail(String email);
	
}
