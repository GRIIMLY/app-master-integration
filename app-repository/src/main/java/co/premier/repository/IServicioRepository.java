package co.premier.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.premier.repository.entity.ServicioEntity;

@Repository
public interface IServicioRepository extends CrudRepository<ServicioEntity, Long>, JpaRepository<ServicioEntity, Long> {

	@Modifying
	@Transactional
	Integer borarEntidad(@Param("id") Long id);

}
