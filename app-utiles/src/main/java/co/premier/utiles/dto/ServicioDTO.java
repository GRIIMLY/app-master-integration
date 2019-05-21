package co.premier.utiles.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioDTO {

	@ApiModelProperty(notes = "Id del Servicio")
	private Long id;
	@ApiModelProperty(notes = "Nombre del Servicio")
	private String nombre;
	@ApiModelProperty(notes = "Url del Servicio")
	private String url;
	@ApiModelProperty(notes = "Tipo de Servicio")
	private String tipo;
	@ApiModelProperty(notes = "Estado del Servicio")
	private String estado;
	@ApiModelProperty(notes = "Descripcion del Servicio")
	private String descripcion;
	@ApiModelProperty(notes = "Tipo Metodo del Servicio")
	private TipoMetodoDTO tipMetodo;
	// No existe en la entidad se debe personalizar
	@ApiModelProperty(notes = "Id de la Aplicacion")
	private Long idAplicacion;
}
