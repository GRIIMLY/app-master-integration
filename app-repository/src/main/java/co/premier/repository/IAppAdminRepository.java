package co.premier.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.premier.repository.entity.AppAdminEntity;

@Repository
public interface IAppAdminRepository extends CrudRepository<AppAdminEntity, Long>, JpaRepository<AppAdminEntity, Long> {
	
	
	/**
	 * Declaración de un metodo el cual actualiza el estado de la aplicación admin
	 * @param codigo
	 * @return
	 */
	@Modifying
	@Transactional
	Integer borrarAppAdmin(@Param("codigo") String codigo);
	
}
