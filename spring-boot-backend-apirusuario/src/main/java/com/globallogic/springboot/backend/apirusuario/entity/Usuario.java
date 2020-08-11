package com.globallogic.springboot.backend.apirusuario.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

//@GeneratedValue(strategy = GenerationType.IDENTITY)
// "^[0-9]+$"; solo numeros
	public final static String FORMATO_CLAVE =  "([A-Z][a-z]+[0-9]{2})";
	public final static String FORMATO_CORREO = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$";

	@Id
	private String id;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String name;

	//@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "no puede estar vacio")
	@Pattern(regexp = FORMATO_CORREO, message = "El correo debe cumplir con el formato correcto aaaaaa@dominio.cl")
	private String email;

	
	@Column(nullable = false)
	@NotEmpty(message = "no puede estar vacio")
	@Pattern(regexp = FORMATO_CLAVE, message = "debe tener las siguientes caracteres una Mayúscula, letras minúsculas, y dos números)")
	private String password;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modified;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at")
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creatAt;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference
	private List<Telefono> telefonos;
	
	private Boolean enabled;
	
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@PrePersist
	public void prePErsist() {
		creatAt = new Date();
		modified = creatAt;
		String result = java.util.UUID.randomUUID().toString();

		result.replaceAll("-", "");
		result.substring(0, 32);
		id = result;
	}

	@PreUpdate
	private void onUpdate() {
		this.modified = new Date();
	}

	public Usuario() {
		this.telefonos = new ArrayList<Telefono>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public Date getCreatAt() {

		return creatAt;

	}

	public void setCreatAt(Date creatAt) {

		this.creatAt = creatAt;

	}

	public void addTelefono(Telefono telefono) {

		this.telefonos.add(telefono);

	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	private static final long serialVersionUID = 1L;

}