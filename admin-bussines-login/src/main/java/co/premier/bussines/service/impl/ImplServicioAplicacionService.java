package co.premier.bussines.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.bussines.service.IServicioAplicacionService;
import co.premier.repository.IServicioRepository;
import co.premier.repository.entity.ServicioEntity;

@Service
public class ImplServicioAplicacionService implements IServicioAplicacionService {

	@Autowired
	IServicioRepository servicioRepository;

	@Override
	public ServicioEntity save(ServicioEntity servicio) {
		return servicioRepository.save(servicio);
	}

	@Override
	public Boolean deleteById(Long id) {
		Integer aux = servicioRepository.borarEntidad(id);
		return (aux.equals(Integer.valueOf("0")) ? Boolean.FALSE : Boolean.TRUE);
	}

	@Override
	public Optional<ServicioEntity> getByID(Long id) {
		return servicioRepository.findById(id);
	}

}
