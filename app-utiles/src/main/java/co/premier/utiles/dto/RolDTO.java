package co.premier.utiles.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RolDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id del Rol")
	private Long id;
	@ApiModelProperty(notes = "Nombre del Rol")
	private String nombre;
}
