package co.premier.bussines.service;

import java.util.List;

import co.premier.repository.entity.TipoMetodoEntity;

public interface ITipoMetodoService {
	
	 public TipoMetodoEntity get(Long id);
	 public List<TipoMetodoEntity> getAll();
	 public void post(TipoMetodoEntity entity);
	 public void put(TipoMetodoEntity entity, long id);
	 public Boolean delete(Long id);

}
