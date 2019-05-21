package co.premier.adminbussines.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.adminbussines.service.IRolService;
import co.premier.repository.IRolRepository;
import co.premier.repository.IUsuarioRepository;
import co.premier.repository.entity.RolEntity;
import co.premier.repository.entity.UsuarioEntity;

@Service
public class RolService implements IRolService {

	@Autowired
	IUsuarioRepository usuarioRepository;

	@Autowired
	IRolRepository rolRepository;

	@Override
	public Optional<RolEntity> save(RolEntity entity) {
		if (entity == null) {
			return Optional.empty();
		}
		return Optional.of(rolRepository.save(entity));
	}

	@Override
	public Optional<Set<RolEntity>> findRolesByUser(String usuario) {
		Optional<UsuarioEntity> userEntity = usuarioRepository.findByUsuario(usuario);
		if (userEntity.isPresent()) {
			return Optional.of(userEntity.get().getRolesRest());
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> modifyRoleRestByUser(Long idUser, List<RolEntity> idRoleRest) {
		if (!rolRepository.deleteRoleRestByUser(idUser)) {
			return Optional.of(Boolean.FALSE);
		}
		if (!rolRepository.saveRolesRestByUser(idUser, idRoleRest)) {
			return Optional.of(Boolean.FALSE);
		}
		return Optional.of(Boolean.TRUE);
	}

	@Override
	public Optional<List<RolEntity>> findAll() {
		List<RolEntity> lista = rolRepository.findAll();
		if (lista.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(lista);
	}

	@Override
	public Optional<Boolean> deleteRole(Long idRol) {
		if (Integer.valueOf(1).equals(rolRepository.borrarRol(idRol))) {
			return Optional.of(Boolean.TRUE);
		}
		return Optional.of(Boolean.FALSE);
	}

	@Override
	public Optional<RolEntity> updateRol(RolEntity rolEntity) {
		if (rolEntity != null) {
			return Optional.of(rolRepository.save(rolEntity));
		}
		return Optional.empty();
	}

}