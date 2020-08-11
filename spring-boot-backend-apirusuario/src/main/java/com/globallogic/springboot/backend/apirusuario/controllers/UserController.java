package com.globallogic.springboot.backend.apirusuario.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.springboot.backend.apirusuario.auth.JWTAuthorizationFilter;
import com.globallogic.springboot.backend.apirusuario.entity.Credencial;

import io.jsonwebtoken.Jwts;

@RestController
public class UserController {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	public static final long EXPIRATION_DATE = System.currentTimeMillis() + 600000;
	
	
	
	@PostMapping("/api/user")
	public Credencial login(@RequestParam("user") String iduser, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(iduser);
		Credencial user = new Credencial();
		user.setUsuario(iduser);
		user.setToken(token);
		return user;

	}
	
	private String getJWTToken(String username) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(EXPIRATION_DATE))
				.signWith(JWTAuthorizationFilter.SECRET_KEY).compact();
		logger.info("getJWTToken:::: " + token);
		return "Bearer " + token;
	}
	

}
