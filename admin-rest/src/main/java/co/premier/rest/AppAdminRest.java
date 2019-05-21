package co.premier.rest;

import java.util.ArrayList;
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

import co.premier.adminbussines.service.IAppAdminService;
import co.premier.adminbussines.service.IUsuarioService;
import co.premier.repository.entity.AppAdminEntity;
import co.premier.repository.entity.UsuarioEntity;
import co.premier.utiles.dto.AppAdminDTO;
import co.premier.utiles.dto.UsuarioDTO;
import co.premier.utiles.dto.respuesta.ResponseRestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1.0/appadmin")
@Api(value = "Rest Controller para el manejo de usuario administrador")
public class AppAdminRest {
	
	@Autowired
	IAppAdminService appAdminService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	ModelMapper mapper;
	
	
	@RequestMapping(value = "/test" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String  test(){
		return "respondiendo test";
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.GET, produces = "application/json" )
	@ApiOperation(value =  "Este servicio se encarga de consultar la información de las aplicaciones de la tabla app_admin")
	public ResponseEntity<ResponseRestService< AppAdminDTO[] > > getRoles(){
		Optional<List<AppAdminEntity>> apps = appAdminService.getAll();
		if (!apps.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<AppAdminDTO[]>( mapper.map(apps.get(), AppAdminDTO[].class) )  ,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/" , method = RequestMethod.POST, produces = "application/json" , consumes = "application/json" )
	@ApiOperation(value =  "Este servicio se encarga de insertar información de una aplicación en la tabla app_admin")
	public ResponseEntity< ResponseRestService< AppAdminDTO > > saveRol(@RequestBody AppAdminDTO app){
		 Optional<AppAdminEntity> appEntity  = appAdminService.save(mapper.map(app, AppAdminEntity.class));
		if (!appEntity.isPresent()) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new ResponseRestService<AppAdminDTO>(mapper.map(appEntity.get(), AppAdminDTO.class)) ,HttpStatus.CREATED);
	}	
	
	@RequestMapping(value = "/" , method = RequestMethod.DELETE)
	@ApiOperation(value =  "Este servicio se encarga de 'eliminar' un aplicación de la tabla app_admin, realizando el cambio de estado de ACTIVO por INACTIVO, utilizando como filtro el codigo")
	public ResponseEntity<ResponseRestService<Boolean> > deleteRol(@RequestParam("codigo") String codigo){
		if (!appAdminService.deleteAppAdmin(codigo).get()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>(new ResponseRestService<>(Boolean.TRUE),HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/" , method = RequestMethod.PUT)
	@ApiOperation(value =  "Este servicio se encarga de actualizar la información de una aplicación en la tabla app_admin")
	public ResponseEntity< ResponseRestService<AppAdminDTO> >updateRol(@RequestBody AppAdminDTO app ){		
		Optional<AppAdminEntity> appT = appAdminService.updateAppAdmin(mapper.map(app, AppAdminEntity.class));
		if (!appT.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<>(new ResponseRestService<>(app),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios/", method = RequestMethod.POST, produces = "application/json", consumes  = "application/json")
	@ApiOperation(value =  "Este servicio se encarga de insertar un usuario en la tabla app_usuarios")
	public ResponseEntity<ResponseRestService <List<UsuarioDTO> > > saveUsuario(@RequestBody(required = true) AppAdminDTO app) {
		List<UsuarioDTO> listUsuarios = new ArrayList<>();
		for(UsuarioDTO item : app.getUsuarios()) {
			UsuarioEntity usuarioEntity = mapper.map(item,  UsuarioEntity.class);
			usuarioEntity.setAppAdmin(new AppAdminEntity());
			usuarioEntity.getAppAdmin().setId(app.getId());
			listUsuarios.add(mapper.map(usuarioService.save(usuarioEntity), UsuarioDTO.class)); 
			
		}
		return new ResponseEntity<>(new ResponseRestService<List<UsuarioDTO>>(listUsuarios), HttpStatus.OK);
	}

}
