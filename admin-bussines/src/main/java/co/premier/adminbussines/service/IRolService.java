package co.premier.adminbussines.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import co.premier.repository.entity.RolEntity;

public interface IRolService {

	
	
	/**
	 * Metodo con el cual guardo un rol 
	 * @param entity
	 * @return
	 */
	Optional<RolEntity> save(RolEntity entity);
	/**
	 * Metodo con el cual por medio del usuario se buscan los roles 
	 * @return
	 */
	Optional<Set<RolEntity>> findRolesByUser(String usuario);
	
	/**
	 * Metodo con el cual modifico los roles de un usuario 
	 * @param idUser
	 * @return
	 */
	Optional<Boolean> modifyRoleRestByUser(Long idUser, List<RolEntity> idRoleRest);
	/**
	 * Metodo con el cual se consulta todas los roles
	 * @return
	 */
	
	Optional<List<RolEntity>> findAll();
	
	/**
	 * Metodo el cual inactiva un rol
	 * @param idRol
	 * @return
	 */
	Optional<Boolean> deleteRole(Long idRol);
	
	
	/**
	 * Metodo el cual actualiza el rol
	 * @param rolEntity
	 * @return
	 */
	
	Optional<RolEntity> updateRol(RolEntity rolEntity);
}
