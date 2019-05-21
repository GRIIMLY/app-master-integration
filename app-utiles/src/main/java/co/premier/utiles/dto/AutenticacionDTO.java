package co.premier.utiles.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacionDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id de la Auditoria")
	private Long id;
	@ApiModelProperty(notes = "Tipo de Auditoria")
	private String tipo;
	@ApiModelProperty(notes = "Usuario que realizara la auditoria")
	private String usuario;
	@ApiModelProperty(notes = "Clave con que accedera el usuario para realizar la auditoria")
	private String contrasenia;
}
