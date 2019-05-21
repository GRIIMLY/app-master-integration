package co.premier.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.premier.bussines.service.IConfigAdicionalService;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1.0/configAdicionalInt")
public class ConfigAdicionalRest {

	@Autowired
	IConfigAdicionalService configService;

	@Autowired
	ModelMapper mapper;

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de 'eliminar' una registro de la tabla app_configuracion_adicional realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como filtro el id.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de actualizar el estado  de la tabla app_configuracion_adicional."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de de actualizar el estado de la tabla app_configuracion_adicional."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de actualizar el estado de la tabla app_configuracion_adicional.") })
	public ResponseEntity<ResponseRestService<Boolean>> deleteById(@RequestParam("id") Long id) {
		if (!configService.borrarConfigAdic(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<>(new ResponseRestService<Boolean>(Boolean.TRUE), HttpStatus.OK);
	}

}
