package co.premier.security.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import co.premier.security.service.ITokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@Service
public class TokenService implements ITokenService{

	@Value("${jwt.secret}")
	private String secret;
	
	@Override
	public String generarToken(String user, List<GrantedAuthority> grantedAuthorities) {
		String jwt = "";
		Instant now = Instant.now();
		
		jwt = Jwts.builder().setSubject(user)
				.claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(Date.from(now)).setExpiration(Date.from(now.plus(1,ChronoUnit.DAYS)))
				.signWith(SignatureAlgorithm.HS512, TextCodec.BASE64.encode(secret)).compact();
		return jwt;
	}

}
