package co.premier.rest;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.premier.adminbussines.service.IRolService;
import co.premier.repository.entity.RolEntity;
import co.premier.utiles.dto.RolDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1.0/roles")
@Api(value = "Rest Controller para el manejo de roles")
public class RolRest {
	
	@Autowired
	IRolService rolService;
	
	@Autowired
	ModelMapper mapper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Este servicio se encarga de consultar todos los roles de la tabla app_roles")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de consultar todos los roles"),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de consultar todos los roles"),
			@ApiResponse(code = 404, message = "No se encuentra el servicio que se encarga de consultar todos los roles") })
	public ResponseEntity<ResponseRestService<RolDTO[]>> getRoles() {
		Optional<List<RolEntity>> roles = rolService.findAll();
		if (!roles.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<RolDTO[]>( mapper.map(roles.get(), RolDTO[].class) ), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/" , method = RequestMethod.POST, produces = "application/json" , consumes = "application/json" )
	@ApiOperation(value ="Este servicio se encarga de insertar un nuevo rol en la tabla app_roles")
	@ApiResponses(value = {@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de insertar un nuevo rol"),
			@ApiResponse(code = 403 ,message = "No está autenticado para acceder al servicio que se encarga de insertar un nuevo rol"),
			@ApiResponse(code = 404, message = "No se encuentra el servicio que se encarga de insertar un nuevo rol")})
	public ResponseEntity<ResponseRestService <RolDTO> > saveRol(@RequestBody RolDTO rol){
		Optional<RolEntity> rolEntity = rolService.save(mapper.map(rol, RolEntity.class ));
		if (!rolEntity.isPresent()) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ResponseRestService<RolDTO>(mapper.map(rolEntity.get(), RolDTO.class)) ,HttpStatus.CREATED);
	}	
	
	
	@RequestMapping(value = "/" , method = RequestMethod.DELETE)
	@ApiOperation(value ="Este servicio se encarga de 'eliminar' la información de un rol en la tabla app_roles, realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como filtro el id")
	@ApiResponses(value = {@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de eliminar un rol"),
			@ApiResponse(code = 403 ,message = "No está autenticado para acceder al servicio que se encarga de eliminar un rol"),
			@ApiResponse(code = 404, message = "No se encuentra el servicio que se encarga de eliminar un rol")})
	public ResponseEntity<ResponseRestService<Boolean>> deleteRol(@RequestParam("id") Long id){	
			
		if (!rolService.deleteRole(id).get()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>(new ResponseRestService<>(Boolean.TRUE),HttpStatus.OK);
	}	

	
	@RequestMapping(value = "/" , method = RequestMethod.PUT, produces = "application/json" , consumes = "application/json")
	@ApiOperation(value ="Este servicio se encarga de actualizar la información de un rol en la tabla app_roles")
	@ApiResponses(value = {@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de actualizar un rol"),
			@ApiResponse(code = 403 ,message = "No está autenticado para acceder al servicio que se encarga de actualizar un rol"),
			@ApiResponse(code = 404, message = "No se encuentra el servicio que se encarga de actualizar un rol")})
	public ResponseEntity<ResponseRestService <RolDTO> > updateRol(@RequestBody (required = true) RolDTO rol){	
		
		Optional<RolEntity> rolT = rolService.updateRol(mapper.map(rol, RolEntity.class));
		if (!rolT.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>( new ResponseRestService<>(rol),HttpStatus.OK);
	}	

	
}
