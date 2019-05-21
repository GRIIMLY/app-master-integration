package co.premier.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.premier.repository.entity.RolEntity;

@Repository
public interface IRolRepository  extends JpaRepository<RolEntity, Long>, CrudRepository<RolEntity, Long>, IRolRepositoryCustom {

	/**
	 * metodo que se encarga de inactivar un rol
	 * @param id
	 * @return
	 */
	@Modifying
	@Transactional
	Integer borrarRol(@Param("id") Long id);
}
