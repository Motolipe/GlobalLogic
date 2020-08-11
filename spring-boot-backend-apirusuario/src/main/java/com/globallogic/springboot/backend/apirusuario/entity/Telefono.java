package com.globallogic.springboot.backend.apirusuario.entity;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "telefonos")

public class Telefono implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numberPhone;

	@Column(nullable = false)
	private int citycode;

	@Column(nullable = false)
	private int contrycode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Usuario usuario;
	
	
	public Telefono() {
	}

	public Long getNumberPhone() {

		return numberPhone;

	}

	public void setNumberPhone(Long numberPhone) {

		this.numberPhone = numberPhone;

	}

	public int getCitycode() {

		return citycode;

	}

	public void setCitycode(int citycode) {

		this.citycode = citycode;

	}

	public int getContrycode() {

		return contrycode;

	}

	public void setContrycode(int contrycode) {

		this.contrycode = contrycode;

	}

	public Usuario getUsuario() {

		return usuario;

	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;

	}

	/**
	
	*
	
	*/

	private static final long serialVersionUID = 1107801852125460689L;

}
