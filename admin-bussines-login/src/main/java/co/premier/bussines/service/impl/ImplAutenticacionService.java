package co.premier.bussines.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.bussines.service.IAutenticacionService;
import co.premier.repository.IAutenticacionRepository;
import co.premier.repository.entity.AutenticacionEntity;

@Service
public class ImplAutenticacionService implements IAutenticacionService{
	
	@Autowired
	IAutenticacionRepository autRepository;
	
	
	@Override
	public AutenticacionEntity get(Long id) {
		return autRepository.findById(id).get();
	}

	@Override
	public Optional<List<AutenticacionEntity>> getAll() {
		List<AutenticacionEntity> aut = autRepository.findAll();
		if (aut.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(aut);
	}

	@Override
	public AutenticacionEntity insert(AutenticacionEntity entity) {
		return autRepository.save(entity);
	}

	@Override
	public void update(AutenticacionEntity entity) {
		autRepository.findById(entity.getId()).ifPresent((x)->{
			autRepository.save(entity);
		});
		
	}

	@Override
	public Boolean delete(Long id) {
		autRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public Boolean borrarAutenticacion(Long id) {
		if (Integer.valueOf(1).equals(autRepository.borrarAutenticacion(id))) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	

}
