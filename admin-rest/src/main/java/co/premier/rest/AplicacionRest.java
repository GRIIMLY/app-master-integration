package co.premier.rest;

import java.util.ArrayList;
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

import co.premier.bussines.service.IAplicacionIntegraService;
import co.premier.bussines.service.IAutenticacionService;
import co.premier.bussines.service.IConfigAdicionalService;
import co.premier.bussines.service.IServicioAplicacionService;
import co.premier.repository.entity.AplicacionIntegraEntity;
import co.premier.repository.entity.AutenticacionEntity;
import co.premier.repository.entity.ConfigAdicionalEntity;
import co.premier.repository.entity.ServicioEntity;
import co.premier.utiles.dto.AplicacionIntegraDTO;
import co.premier.utiles.dto.AutenticacionDTO;
import co.premier.utiles.dto.ConfigAdicionalDTO;
import co.premier.utiles.dto.ServicioDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1.0/aplicacionesInt")
@Api(value = "Rest Controller para la Aplicacion")
public class AplicacionRest {

	@Autowired
	IAplicacionIntegraService appService;

	@Autowired
	ModelMapper mapper;

	@Autowired
	IAutenticacionService autService;

	@Autowired
	IServicioAplicacionService servicioAplicacionService;

	@Autowired
	IConfigAdicionalService configService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Hola test";
	}

	@RequestMapping(value = "/by/", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de consultar la informacion de la tabla Aplicaciones utilizando como filtro el codigo.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de consultar la informacion de la tabla Aplicaciones ."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de consultar la informacion de la tabla Aplicaciones ."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de consultar la informacion de la tabla Aplicaciones .") })
	public ResponseEntity<ResponseRestService < AplicacionIntegraDTO> > findByCode(@RequestParam("codigo") String codigo) {
		AplicacionIntegraEntity app = appService.findByCode(codigo);
		if (app == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>( mapper.map(app, AplicacionIntegraDTO.class) ), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de consultar toda la informacion de la tabla Aplicaciones.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de consultar toda la informacion de la tabla Aplicaciones."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de consultar toda la informacion de la tabla Aplicaciones."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de consultar toda la informacion de la tabla Aplicaciones.") })
	public ResponseEntity< ResponseRestService<AplicacionIntegraDTO[] > > findAll() {
		Optional<List<AplicacionIntegraEntity>> app = appService.buscarTodos();
		if (!app.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService< AplicacionIntegraDTO[] >(mapper.map(app.get(), AplicacionIntegraDTO[].class) ) , HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Este servicio se encargara de 'eliminar' una registro de la tabla aplicacion realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como parametro el codigo.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de actualizar el estado de la tabla aplicacion."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de de actualizar el estado de la tabla aplicacion."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de actualizar el estado de la tabla aplicacion.") })
	public ResponseEntity< ResponseRestService<Boolean> > deleteById(@RequestParam("codigo") String codigo) {
		if (!appService.borrarAplicacion(codigo)) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>(new ResponseRestService<>(Boolean.TRUE), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Este servicio se encargara de guardar un registro en la tabla app_aplicacion_integra.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de guardar un registro en la tabla app_aplicacion_integra."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de guardar un registro en la tabla app_aplicacion_integra."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de guardar un registro en la tabla app_aplicacion_integra") })
	public ResponseEntity<ResponseRestService<AplicacionIntegraDTO>> saveEntity(@RequestBody(required = true) AplicacionIntegraDTO appDTO) {
		AplicacionIntegraDTO app = mapper.map(appService.post(mapper.map(appDTO, AplicacionIntegraEntity.class)),
				AplicacionIntegraDTO.class);
		return new ResponseEntity<>(new ResponseRestService<>(app), HttpStatus.OK);
	}

	@RequestMapping(value = "/autenticacionInt/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Este servicio se encargara de guardar un registro en la tabla app_aplicacion_integra.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de guardar un registro en la tabla app_aplicacion_integra."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de guardar un registro en la tabla app_aplicacion_integra."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de guardar un registro en la tabla app_aplicacion_integra") })
	public ResponseEntity<ResponseRestService< List<AutenticacionDTO>>> saveAutenticacion(
			@RequestBody(required = true) AplicacionIntegraDTO aplicacionDto) {

		List<AutenticacionDTO> lista = new ArrayList<AutenticacionDTO>();

		for (AutenticacionDTO item : aplicacionDto.getAutenticaciones()) {
			AutenticacionEntity autenticacionEntity = mapper.map(item, AutenticacionEntity.class);
			autenticacionEntity.setAplicacion(new AplicacionIntegraEntity());
			autenticacionEntity.getAplicacion().setId(aplicacionDto.getId());
			AutenticacionDTO servicioDto = mapper.map(autService.insert(autenticacionEntity), AutenticacionDTO.class);
			lista.add(servicioDto);
		}
		return new ResponseEntity<>( new ResponseRestService<List<AutenticacionDTO>>( lista ) , HttpStatus.OK);
	}

	@RequestMapping(value = "/servicios/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseRestService<List<ServicioDTO>>> save(
			@RequestBody(required = true) AplicacionIntegraDTO aplicacionIntegraDTO) {
		List<ServicioDTO> lista = new ArrayList<ServicioDTO>();
		for (ServicioDTO item : aplicacionIntegraDTO.getServicios()) {
			ServicioEntity servicioEntity = mapper.map(item, ServicioEntity.class);
			servicioEntity.setAplicacion(new AplicacionIntegraEntity());
			servicioEntity.getAplicacion().setId(aplicacionIntegraDTO.getId());
			ServicioDTO servicioDto = mapper.map(servicioAplicacionService.save(servicioEntity), ServicioDTO.class);
			lista.add(servicioDto);
		}
		return new ResponseEntity<>(new ResponseRestService<List<ServicioDTO>>( lista), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/configAdicionalInt/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Este servicio se encargara de guardar la configuracion de la autenticacion en la tabla app_configuracion_adicional.")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "No está autorizado para acceder al servicio que se encarga de guardar la autenticacion en la tabla app_configuracion_adicional."),
			@ApiResponse(code = 403, message = "No está autenticado para acceder al servicio que se encarga de guardar  la autenticacion en la tabla app_configuracion_adicional."),
			@ApiResponse(code = 404, message = "No encuentra el servicio que se encarga de guardar  la autenticacion en la tabla app_configuracion_adicional.") })
	public ResponseEntity<ResponseRestService<List<ConfigAdicionalDTO>>> saveConfigurationAutenticacion(
			@RequestBody(required = true) AplicacionIntegraDTO aplicacionDto) {

		List<ConfigAdicionalDTO> lista = new ArrayList<ConfigAdicionalDTO>();

		for (ConfigAdicionalDTO item : aplicacionDto.getConfiguracionesAdic()) {
			ConfigAdicionalEntity configAdicEntity = mapper.map(item, ConfigAdicionalEntity.class);
			configAdicEntity.setAplicacion(new AplicacionIntegraEntity());
			configAdicEntity.getAplicacion().setId(aplicacionDto.getId());
			ConfigAdicionalDTO servicioDto = mapper.map(configService.insert(configAdicEntity),
					ConfigAdicionalDTO.class);
			lista.add(servicioDto);
		}
		return new ResponseEntity<>(new ResponseRestService<List<ConfigAdicionalDTO>>(lista), HttpStatus.OK);
	}

}
