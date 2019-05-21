package co.premier.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.premier.repository.entity.ConfigAdicionalEntity;

@Repository
public interface IConfigAdicionalRepository extends CrudRepository<ConfigAdicionalEntity, Long>, JpaRepository<ConfigAdicionalEntity, Long> {

	/**
	 * Inactiva la configuracion de la aplicación dependien el id.
	 * @param id Id de la configuración
	 * @return
	 */
	@Modifying
	@Transactional
	Integer borrarConfigAdic(@Param("id") Long id);
}
