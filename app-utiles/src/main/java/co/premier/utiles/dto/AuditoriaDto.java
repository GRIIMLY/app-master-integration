package co.premier.utiles.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriaDto {

	@ApiModelProperty(notes = "Auditoria creada por")
	private String createdBy;
	@ApiModelProperty(notes = "Fecha creacion de la Auditoria")
	private Date createdDate;
	@ApiModelProperty(notes = "Ultimo en modificar la Auditoria")
	private String lastModifiedBy;
	@ApiModelProperty(notes = "Ultima fecha de modificacion de la Auditoria")
	private Date lastModifiedDate;
	@ApiModelProperty(notes = "Estado de la Auditoria")
	private String estado;

}
