package co.premier.utiles.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigAdicionalDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id de la Auditoria")
	private Long id;
	@ApiModelProperty("Configuracion de la Auditoria")
	private String configuracion;
	@ApiModelProperty(notes = "Valor de la Auditoria")
	private String valor;

}
