package co.premier.bussines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.bussines.service.IConfigAdicionalService;
import co.premier.repository.IConfigAdicionalRepository;
import co.premier.repository.entity.ConfigAdicionalEntity;

@Service
public class ImplConfigAdicionalService implements IConfigAdicionalService{

	@Autowired
	IConfigAdicionalRepository configRepository;
	
	@Override
	public ConfigAdicionalEntity get(Long id) {
		return configRepository.findById(id).get();
	}

	@Override
	public List<ConfigAdicionalEntity> getAll() {
		return (List<ConfigAdicionalEntity>) configRepository.findAll();
	}

	@Override
	public ConfigAdicionalEntity insert(ConfigAdicionalEntity entity) {
		return configRepository.save(entity);
	}

	@Override
	public void put(ConfigAdicionalEntity entity, Long id) {
		configRepository.findById(id).ifPresent((x)->{
			entity.setId(id);
			configRepository.save(entity);
		});
	}

	@Override
	public Boolean delete(Long id) {
		configRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public Boolean borrarConfigAdic(Long id) {
		if(Integer.valueOf(1).equals(configRepository.borrarConfigAdic(id))) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}


}
