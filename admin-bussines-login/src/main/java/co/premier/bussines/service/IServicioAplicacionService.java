package co.premier.bussines.service;

import java.util.Optional;

import co.premier.repository.entity.ServicioEntity;

public interface IServicioAplicacionService {

	/**
	 * Metodo con el cual persisto la entidad servicio aplicacion
	 * 
	 * @param servicio
	 * @return
	 */
	ServicioEntity save(ServicioEntity servicio);

	/**
	 * Metodo que cambia el estado la entidad
	 * 
	 * @param id
	 * @return
	 */
	Boolean deleteById(Long id);

	/**
	 * Metodo con el cual obtengo el objeto del servicio consultando por id.
	 * 
	 * @param id
	 * @return
	 */
	Optional<ServicioEntity> getByID(Long id);

}
