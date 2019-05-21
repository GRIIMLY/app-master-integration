package co.premier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.premier.repository.entity.TipoMetodoEntity;

@Repository
public interface ITipoMetodoRepository extends CrudRepository<TipoMetodoEntity, Long>, JpaRepository<TipoMetodoEntity, Long>{

}
