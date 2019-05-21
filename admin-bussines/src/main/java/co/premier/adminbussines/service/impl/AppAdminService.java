package co.premier.adminbussines.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.adminbussines.service.IAppAdminService;
import co.premier.repository.IAppAdminRepository;
import co.premier.repository.entity.AppAdminEntity;

@Service
public class AppAdminService implements IAppAdminService {

	@Autowired
	public IAppAdminRepository aRepository;

	@Override
	public Optional<AppAdminEntity> getById(Long id) {

		return aRepository.findById(id);
	}

	@Override
	public Optional<List<AppAdminEntity>> getAll() {
		List<AppAdminEntity> apps = aRepository.findAll();
		if (apps.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(apps);
	}


	@Override
	public Optional<AppAdminEntity> save(AppAdminEntity entity) {
		if (entity == null) {
			return Optional.empty();
		}
		return Optional.of(aRepository.save(entity));
	}

	@Override
	public Optional<Boolean> deleteAppAdmin(String codigo) {
		if (Integer.valueOf(1).equals(aRepository.borrarAppAdmin(codigo))) {
			return Optional.of(Boolean.TRUE);
		}
		return Optional.of(Boolean.FALSE);	}

	@Override
	public Optional<AppAdminEntity> updateAppAdmin(AppAdminEntity entity) {
		if (entity != null) {
			return Optional.of(aRepository.save(entity));
		}
		return Optional.empty();
	}

}
