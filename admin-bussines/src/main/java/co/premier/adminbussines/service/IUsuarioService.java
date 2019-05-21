package co.premier.adminbussines.service;

import java.util.List;
import java.util.Optional;

import co.premier.repository.entity.UsuarioEntity;

public interface IUsuarioService {
	
	/**
	 * Metodo con el cual guardamos un usuario en el sistema
	 * @return
	 */
	UsuarioEntity save(UsuarioEntity usuario);
	/**
	 * Metodo con el cual obtengo todos los usuarios
	 * @return
	 */
	List<UsuarioEntity> getAll();
	/**
	 * Metodo con el cual se valida si las credenciales de un usuario son correctas
	 * @param usuario
	 * @param contra
	 * @return
	 */
	Boolean validateAuth(String usuario, String contra);
	
	/**
	 * Metodo con el cual se le cambia el estado al usuario
	 * @param codigo
	 * @return
	 */
	Optional<Boolean> deleteUsuario(String codigo);
	
	/**
	 * Metodo con el cual se actualiza un usuario
	 * @param eEntity
	 * @return
	 */
	Optional<UsuarioEntity> updateUsuario(UsuarioEntity eEntity);
	
}
