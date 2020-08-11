package com.globallogic.springboot.backend.apirusuario.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.globallogic.springboot.backend.apirusuario.entity.Usuario;
import com.globallogic.springboot.backend.apirusuario.services.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController
{

	@Autowired
	private IUsuarioService usuarioServices;
	
	

	@GetMapping("/listar")
	@Transactional(readOnly = true)
	public List<Usuario> index() {
		return usuarioServices.findAll();
	}

	@PostMapping("/usuario")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		Usuario usuarioNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Boolean existe = true;
			existe = usuarioServices.existsByDscEmail(usuario.getEmail());
			if (existe) {
				response.put("mensaje",
						"El email " + usuario.getEmail() + " ya exite en la base de datos, favor ingresar otro email!");
			} else {
				usuarioNew = usuarioServices.save(usuario);
				response.put("mensaje", "El usuario ha sido creado con éxito!");
				response.put("usuario", usuarioNew);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result,
			@PathVariable String id) {
		Usuario usuarioActual = usuarioServices.findById(id);
		Usuario usuarioUpdated = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (usuarioActual == null) {

			response.put("mensaje", "Error: no se pudo editar, la usuario ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			Boolean existe = true;
			existe = usuarioServices.existsByDscEmail(usuario.getEmail());
			if (existe) {
				response.put("mensaje",
						"El email " + usuario.getEmail() + " ya exite en la base de datos, favor ingresar otro email!");
			} else {
				usuarioActual.setName(usuario.getName());
				usuarioActual.setEmail(usuario.getEmail());
				usuarioActual.setPassword(usuario.getPassword());
				usuarioUpdated = usuarioServices.save(usuarioActual);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error: al actualizar la usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con éxito!");
		response.put("usuario", usuarioUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

		
	
}