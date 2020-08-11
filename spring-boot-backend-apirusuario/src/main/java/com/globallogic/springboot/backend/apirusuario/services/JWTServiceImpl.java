package com.globallogic.springboot.backend.apirusuario.services;



import javax.crypto.SecretKey;

/*
 * 
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
*/
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;


import io.jsonwebtoken.security.Keys;

@Component
public class JWTServiceImpl implements JWTService {
	/*public static  SecretKey SECRET_KEY = new SecretKeySpec(
			"Alguna.Llave.Secreta.12345".getBytes(),
			SignatureAlgorithm.HS512.getJcaName());*/
	
	public static String clavebase64 = Base64Utils.encodeToString("Alguna.Llave.Secreta.12345".getBytes());

	public static final  SecretKey SECRET_KEY = Keys.hmacShaKeyFor(clavebase64.getBytes());
	
	public static final long EXPIRATION_DATE = 14000000L;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
	


}
