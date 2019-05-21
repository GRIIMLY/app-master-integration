package co.premier.adminbussines.service;

import java.util.List;
import java.util.Optional;

import co.premier.repository.entity.AppAdminEntity;

public interface IAppAdminService {

	
	/**
	 * consulta la entidad por id
	 * @param id
	 * @return
	 */
	Optional<AppAdminEntity> getById(Long id);
	
	/**
	 * Consulta todas las  entidades app
	 * @return
	 */
	Optional<List<AppAdminEntity>> getAll();
	
	/**
	 * Guarda la entidad app
	 * @param entity
	 */
	Optional<AppAdminEntity> save(AppAdminEntity entity);
	
	/**
	 * Actualiza la entidad app
	 * @param entity
	 * @param id
	 */
	Optional<AppAdminEntity> updateAppAdmin(AppAdminEntity entity);

	/**
	 * Elimina la entidad app
	 * @param id
	 * @return
	 */
	Optional<Boolean> deleteAppAdmin(String codigo);

}
