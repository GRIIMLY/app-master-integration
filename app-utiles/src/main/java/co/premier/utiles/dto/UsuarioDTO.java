package co.premier.utiles.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id del Usuario")
	private Long id;
	@ApiModelProperty(notes = "Usuario")
	private String usuario;
	@ApiModelProperty(notes = "Contraseña del Usuario")
	private String contrasena;
	@ApiModelProperty(notes = "Codigo del Usuario")
	private String codigo;
	@ApiModelProperty(notes = "Nombre del Usuario")
	private String nombre;
	@ApiModelProperty(notes = "Roles de Usuario")
	private List<RolDTO> rolesRest;
}
