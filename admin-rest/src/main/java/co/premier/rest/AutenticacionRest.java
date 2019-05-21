package co.premier.rest;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.premier.bussines.service.IAutenticacionService;
import co.premier.repository.entity.AutenticacionEntity;
import co.premier.utiles.dto.AutenticacionDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1.0/autenticacionInt")
@Api(value = "Rest Controller para la Autenticacion.")
public class AutenticacionRest {

	@Autowired
	IAutenticacionService autService;

	@Autowired
	ModelMapper mapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Hola test";
	}

	@RequestMapping(value = "/by/", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de consultar la informacion de la tabla Autenticacion utilizando como filtro el codigo.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de consultar la informacion de la tabla Autenticacion."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de consultar la informacion de la tabla Autenticacion."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de consultar la informacion de la tabla Autenticacion.") })
	public ResponseEntity< ResponseRestService<AutenticacionDTO>> findById(@RequestParam("id") Long id) {
		AutenticacionEntity aut = autService.get(id);
		if (aut == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>( mapper.map(aut, AutenticacionDTO.class) ), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de consultar toda la informacion de la tabla Autenticacion.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de consultar toda la informacion de la tabla Autenticacion."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de consultar toda la informacion de la tabla Autenticacion."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de consultar toda la informacion de la tabla Autenticacion.") })
	public ResponseEntity<ResponseRestService<AutenticacionDTO[]>> findAll() {
		Optional<List<AutenticacionEntity>> aut = autService.getAll();
		if (!aut.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>( new ResponseRestService<AutenticacionDTO[]>( mapper.map(aut.get(), AutenticacionDTO[].class) ), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de 'eliminar' una registro de la tabla Autenticacion realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como filtro el codigo.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de actualizar el estado  de la tabla Autenticacion."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de de actualizar el estado de la tabla Autenticacion."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de actualizar el estado de la tabla Autenticacion.") })
	public ResponseEntity<ResponseRestService<Boolean> > deleteById(@RequestParam("id") Long id) {
		if (!autService.borrarAutenticacion(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<>(new ResponseRestService<>(Boolean.TRUE), HttpStatus.OK);
	}

}
