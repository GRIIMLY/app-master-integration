package co.premier.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.premier.repository.entity.AutenticacionEntity;

@Repository
public interface IAutenticacionRepository extends CrudRepository<AutenticacionEntity, Long>, JpaRepository<AutenticacionEntity, Long>{

	/**
	 * Permite cambiar de esto a una aplicación de Activo a Inactivo con su Id.
	 * @param id Id de la autenticación.
	 * @return
	 */
	
	@Modifying
	@Transactional
	Integer borrarAutenticacion(@Param("id") Long id);
}
