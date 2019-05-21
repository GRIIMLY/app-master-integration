package co.premier.utiles.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AplicacionIntegraDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id de a Auditoria")
	private Long id;
	@ApiModelProperty(notes = "Codigo de la Auditoria")
	private String codigo;
	@ApiModelProperty(notes = "Nombre de la Auditoria")
	private String nombre;
	@ApiModelProperty(notes = "Lista del objeto Autenticaciones")
	private List<AutenticacionDTO> autenticaciones;
	@ApiModelProperty(notes = "Lista del objeto Configuraciones Adicionales")
	private List<ConfigAdicionalDTO> configuracionesAdic;
	@ApiModelProperty(notes = "Lista del objeto Servicios")
	private List<ServicioDTO> servicios;

}
