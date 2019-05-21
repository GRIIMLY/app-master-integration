package co.premier.utiles.dto;

import java.math.BigInteger;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
public class AppAdminDTO extends AuditoriaDto {

	@ApiModelProperty(notes = "Id de la Aplicación")
	private Long id;
	@ApiModelProperty(notes = "Codigo de la Aplicación")
	private String codigo;
	@ApiModelProperty(notes = "Nombre de la Aplicación")
	private String nombre;
	@ApiModelProperty(notes = "Numero de consumos que ha realizado la Aplicación")
	private BigInteger numeroConsumo;
	@ApiModelProperty(notes = "Usuarios asociados a un app")
	private List<UsuarioDTO> usuarios;
}
