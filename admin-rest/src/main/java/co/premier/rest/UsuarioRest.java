package co.premier.rest;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.premier.adminbussines.service.IUsuarioService;
import co.premier.repository.entity.UsuarioEntity;
import co.premier.utiles.dto.UsuarioDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1.0/usuarios")
@Api(value = "Rest Controller para el manejo de usuarios")
public class UsuarioRest {

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	ModelMapper mapper;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value =  "Este servicio se encarga de consultar la información de todos los usuarios de la tabla app_admin")
		public ResponseEntity<ResponseRestService<UsuarioDTO[]>> getUsuarios() {
		List<UsuarioEntity> usuarios = usuarioService.getAll();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<UsuarioDTO[]>( mapper.map(usuarios, UsuarioDTO[].class) ), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json", consumes  = "application/json")
	@ApiOperation(value =  "Este servicio se encarga de 'eliminar' un usuario de la tabla app_usuarios, realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como filtro el codigo")
	public ResponseEntity<ResponseRestService< Boolean >> deleteUsuario(@RequestParam("codigo") String codigo) {		
		if (usuarioService.deleteUsuario(codigo).get()) {
			return new ResponseEntity<>(new ResponseRestService<>( Boolean.TRUE ), HttpStatus.OK);
		} 
		return new ResponseEntity<>(new ResponseRestService<>( Boolean.FALSE ), HttpStatus.NOT_MODIFIED);
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json", consumes  = "application/json")
	@ApiOperation(value =  "Este servicio se encarga de actualizar la información de un usuario en la tabla app_usuarios")
	public ResponseEntity< ResponseRestService<UsuarioDTO> > updateUsuario(@RequestBody(required = true) UsuarioDTO uDTO) {		
		 Optional<UsuarioEntity> usuarioT = usuarioService.updateUsuario(mapper.map(uDTO, UsuarioEntity.class ));
		if (!usuarioT.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} 
		return new ResponseEntity<>(new ResponseRestService<>( uDTO ), HttpStatus.OK);
		
	}

}
