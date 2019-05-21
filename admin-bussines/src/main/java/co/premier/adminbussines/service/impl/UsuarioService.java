package co.premier.adminbussines.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.premier.adminbussines.service.IUsuarioService;
import co.premier.repository.IUsuarioRepository;
import co.premier.repository.entity.UsuarioEntity;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	IUsuarioRepository uRepository;

	@Override
	public UsuarioEntity save(UsuarioEntity usuario) {
		if (usuario.getEstado().equals("INACTIVO")) {
			return null;
		}
		return uRepository.save(usuario);
	}

	@Override
	public List<UsuarioEntity> getAll() {

		return uRepository.obtenerTodosUsuarios();
	}

	@Override
	public Boolean validateAuth(String usuario, String contra) {
		return uRepository.authenticateUser(usuario, contra).isPresent();
	}

	@Override
	public Optional<Boolean> deleteUsuario(String codigo) {
		if (Integer.valueOf(1).equals(uRepository.borrarUsuario(codigo))) {
				return Optional.of(Boolean.TRUE);
		}
		return Optional.of(Boolean.FALSE);
	}

	@Override
	public Optional<UsuarioEntity> updateUsuario(UsuarioEntity eEntity) {
		if (eEntity != null) {
			return Optional.of(uRepository.save(eEntity));
		}
		return null;
	}

}
