package co.premier.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.premier.repository.entity.AplicacionIntegraEntity;

@Repository
public interface IAplicacionIntegraRepository extends CrudRepository<AplicacionIntegraEntity, Long>, JpaRepository<AplicacionIntegraEntity, Long>{
	
	/**
	 * Metodo con el cual realizo la busqueda de una aplicacion por medio de su codigo
	 * @param codigo Es el codigo de la aplicación.
	 * @return
	 */
	AplicacionIntegraEntity buscarPorCodigo(@Param("codigo") String code);
	/**
	 * Metodo con el cual busco todas la aplicaciones de integracion sin filtros
	 * @return
	 */
	List<AplicacionIntegraEntity> buscarTodos();
	/**
	 * Metodo con el cual inactiva una aplicación
	 * @param codigo
	 * @return
	 */
	@Modifying
	@Transactional
	Integer borrarAplicacion(@Param("codigo") String codigo);
}
