package co.premier.security.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public interface ITokenService {
	
	/**
	 * Genera el token JWT para usarse en los servicios.
	 * */
	
	String generarToken(String user, List<GrantedAuthority> grantedAuthorities);

}
