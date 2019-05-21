package co.premier.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.premier.bussines.service.IServicioAplicacionService;
import co.premier.utiles.dto.ServicioDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1.0/serviciosInt")
@Api(value = "Rest Controller para los Servicios.")
public class ServicioRest {

	@Autowired
	IServicioAplicacionService servicioAplicacionService;

	@Autowired
	ModelMapper mapper;

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de 'eliminar' una registro de la tabla app_servicio realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como filtro el id.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de actualizar el estado  de la tabla app_servicio."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de de actualizar el estado de la tabla app_servicio."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de actualizar el estado de la tabla app_servicio.") })
	public ResponseEntity<ResponseRestService<Boolean>> deleteById(@RequestParam("id") Long id) {
		return new ResponseEntity<>(new ResponseRestService<Boolean>(servicioAplicacionService.deleteById(id)),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de consultar la informacion de la tabla app_servicio utilizando como filtro el id.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de consultar la informacion de la tabla app_servicio."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de consultar la informacion de la tabla app_servicio."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de consultar la informacion de la tabla app_servicio.") })
	public ResponseEntity<ResponseRestService<ServicioDTO>> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(new ResponseRestService<ServicioDTO>(
				mapper.map(servicioAplicacionService.getByID(id), ServicioDTO.class)), HttpStatus.OK);
	}

}
