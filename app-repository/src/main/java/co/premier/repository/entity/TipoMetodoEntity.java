package co.premier.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.premier.repository.enumeracion.MetodoTipoInf;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "app_tipo_metodo")
public class TipoMetodoEntity extends Auditoria<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_met")
	private Long id_met;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "metodo")
	private MetodoTipoInf metodo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servicioApli")
	private ServicioEntity servicio;

}
