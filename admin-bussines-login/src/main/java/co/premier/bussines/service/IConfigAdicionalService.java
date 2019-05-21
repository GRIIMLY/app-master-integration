package co.premier.bussines.service;

import java.util.List;

import co.premier.repository.entity.ConfigAdicionalEntity;


public interface IConfigAdicionalService {
	
	 /**
	  * Trae la configuración por Id.
	  * @param id
	  * @return
	  */
	 public ConfigAdicionalEntity get(Long id);
	 
	 /**
	  * Trae todas las configuraciones de la aplicacion
	  * @return
	  */
	 public List<ConfigAdicionalEntity> getAll();
	 
	 /**
	  * Registra una nueva configuración de una aplicación determinada.
	  * @param entity
	  */
	 public ConfigAdicionalEntity insert(ConfigAdicionalEntity entity);
	 
	 /**
	  * Actualiza la configuración de una aplicación
	  * @param entity
	  * @param id
	  */
	 public void put(ConfigAdicionalEntity entity, Long id);
	 
	 /**
	  * Borra la configuración de una aplicación.
	  * @param id
	  * @return
	  */
	 public Boolean delete(Long id);
	 
	 /**
	  * Inhabilita una configuración dependiendo el id que se le mande.
	  * @param id
	  * @return
	  */
	 public Boolean borrarConfigAdic(Long id);

}
