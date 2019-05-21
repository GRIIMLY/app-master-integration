package co.premier.bussines.service;

import java.util.List;
import java.util.Optional;

import co.premier.repository.entity.AplicacionIntegraEntity;

public interface IAplicacionIntegraService {

	/**
	 * Consulta una aplicación por id.
	 * @param id Id de la aplicacionEntity
	 * @return
	 */
	 public AplicacionIntegraEntity get(Long id);
	 
	 /**
	  * Consulta la lista de todas las aplicaciones de Integración.
	  * @return
	  */
	 public List<AplicacionIntegraEntity> getAll();
	 
	 /**
	  * Registra una aplicación
	  * @param entity
	  * @return
	  */
	 public AplicacionIntegraEntity post(AplicacionIntegraEntity entity);
	 
	 /**
	  * Actualiza las aplicaciones por ID
	  * @param entity La entidad que se va a actualizar
	  * @param id El id de la entidad ha actualizar
	  * @return
	  */
	 public Boolean put(AplicacionIntegraEntity entity, long id);
	 
	 /**
	  * Eliminar la aplicacion por Id
	  * @param id Id de la aplicación que se desea eliminar
	  * @return
	  */
	 public Boolean delete(Long id);
	 
	 /**
	  * Consulta una aplicación por su codígo.
	  * @param code Codigo que identifica una aplicación.
	  * @return
	  */
	 public AplicacionIntegraEntity findByCode(String code);
	 
	 /**
	  * Busca todas las aplicaciones de integración
	  * @return
	  */
	 public Optional<List<AplicacionIntegraEntity>> buscarTodos();
	 
	 /**
	  * Borra una aplicación por codigo.
	  * @param codigo El codigo unico de la aplicación
	  * @return
	  */
	 public Boolean borrarAplicacion(String codigo);
	
}
