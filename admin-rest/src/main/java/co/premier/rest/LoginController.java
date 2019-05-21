package co.premier.rest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.premier.adminbussines.service.IRolService;
import co.premier.adminbussines.service.IUsuarioService;
import co.premier.repository.entity.RolEntity;
import co.premier.security.service.ITokenService;
import co.premier.utiles.dto.LoginDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(description = "Rest Controller para Login")
public class LoginController {
	
	@Autowired
	ITokenService tokenService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IRolService roleRestService;
	
	
	@ApiOperation(value = "Este servicio autentica el usuario y contraseña para generar un token que permite el acceso a los demás servicios")
	@RequestMapping(value = "login/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRestService<String>> login(@RequestBody LoginDTO loginDTO){
		if (!usuarioService.validateAuth(loginDTO.getUsuario(),loginDTO.getContrasenia())) {
			return new ResponseEntity<>(new ResponseRestService<>("Credenciales invalidas"), HttpStatus.UNAUTHORIZED);
		}
		Optional<Set<RolEntity>> roles = roleRestService.findRolesByUser(loginDTO.getUsuario());
		if (!roles.isPresent()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		String rolesStr = roles.get().stream().parallel().map(item -> item.getNombre()).reduce((x, y) -> x + "," + y).orElse("");
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(rolesStr);
		
		return new ResponseEntity<>(
				new ResponseRestService<>("Bearer " + tokenService.generarToken(loginDTO.getUsuario(), grantedAuthorities)),
				HttpStatus.OK);
		
	}

}
