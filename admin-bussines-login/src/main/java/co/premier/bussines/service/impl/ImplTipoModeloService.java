package co.premier.bussines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.bussines.service.ITipoMetodoService;
import co.premier.repository.ITipoMetodoRepository;
import co.premier.repository.entity.TipoMetodoEntity;

@Service
public class ImplTipoModeloService implements ITipoMetodoService{

	@Autowired
	ITipoMetodoRepository tipMetodoRepository;
	
	@Override
	public TipoMetodoEntity get(Long id) {
		return tipMetodoRepository.findById(id).get();
	}

	@Override
	public List<TipoMetodoEntity> getAll() {
		return (List<TipoMetodoEntity>) tipMetodoRepository.findAll();
	}

	@Override
	public void post(TipoMetodoEntity entity) {
		tipMetodoRepository.save(entity);
		
	}

	@Override
	public void put(TipoMetodoEntity entity, long id) {
		tipMetodoRepository.findById(id).ifPresent((x)->{
			entity.setId_met(id);
			tipMetodoRepository.save(entity);
		});
	}

	@Override
	public Boolean delete(Long id) {
		tipMetodoRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
