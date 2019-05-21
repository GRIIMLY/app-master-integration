package co.premier.bussines.service;

import java.util.List;
import java.util.Optional;

import co.premier.repository.entity.AutenticacionEntity;


public interface IAutenticacionService {
	
	/**
	 * Busca la autenticación por Id
	 * @param id Id de la autenticación
	 * @return
	 */
	 public AutenticacionEntity get(Long id);
	 
	 /**
	  * Busca todas autenticaciones posibles para una aplicacion
	  * @return
	  */
	 public Optional<List<AutenticacionEntity>> getAll();
	 /**
	  * Realiza la insercion de una aplicacion
	  * @param entity
	  */
	 public AutenticacionEntity insert(AutenticacionEntity entity);
	 /**
	  * Actualiza una entidad
	  * @param entity
	  * @param id
	  */
	 public void update(AutenticacionEntity entity);
	 /**
	  * Borra la Autenticación
	  * @param id
	  * @return
	  */
	 public Boolean delete(Long id);
	 
	 /**
	  * Inactiva la autenticación de la aplicación
	  * @param id Id de la Autenticación.
	  * @return
	  */
	 public Boolean borrarAutenticacion(Long id);

}
