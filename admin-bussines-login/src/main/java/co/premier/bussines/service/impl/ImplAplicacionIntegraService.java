package co.premier.bussines.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.bussines.service.IAplicacionIntegraService;
import co.premier.repository.IAplicacionIntegraRepository;
import co.premier.repository.entity.AplicacionIntegraEntity;

@Service
public class ImplAplicacionIntegraService implements IAplicacionIntegraService{

	@Autowired
	IAplicacionIntegraRepository aplicacionIntegraRepository;

	@Override
	public AplicacionIntegraEntity get(Long id) {
		return aplicacionIntegraRepository.findById(id).get();
	}

	@Override
	public List<AplicacionIntegraEntity> getAll() {
		return (List<AplicacionIntegraEntity>) aplicacionIntegraRepository.findAll();
	}

	@Override
	public AplicacionIntegraEntity post(AplicacionIntegraEntity entity) {
		return aplicacionIntegraRepository.save(entity);
	}

	@Override
	public Boolean put(AplicacionIntegraEntity entity, long id) {
		aplicacionIntegraRepository.findById(id).ifPresent((x)->{
			entity.setId(id);
			aplicacionIntegraRepository.save(entity);
		});
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean delete(Long id) {
		aplicacionIntegraRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public AplicacionIntegraEntity findByCode(String code) {		
		return aplicacionIntegraRepository.buscarPorCodigo(code);
	}

	@Override
	public Optional<List<AplicacionIntegraEntity>> buscarTodos() {
		List<AplicacionIntegraEntity> aplicaciones = aplicacionIntegraRepository.buscarTodos();
		if(aplicaciones.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(aplicaciones);
	}

	@Override
	public Boolean borrarAplicacion(String codigo) {
		if(Integer.valueOf(1).equals(aplicacionIntegraRepository.borrarAplicacion(codigo))) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	
	
}
