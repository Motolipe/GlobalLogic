package com.globallogic.springboot.backend.apirusuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "credenciales")
public class Credencial {
	
	@Id
	private String token;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String contraseña;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String usuario;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	

}
