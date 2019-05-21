package co.premier.utiles.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoMetodoDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id de la Auditoria")
	private Long id;
	@ApiModelProperty(notes = "Metodo de la Auditoria")
	private String metodo;
}
