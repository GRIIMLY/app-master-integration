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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.premier.repository.enumeracion.ConfigAdicionalInf;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "app_configuracion_adicional")
@NamedQueries({
	@NamedQuery(name = "ConfigAdicionalEntity.borrarConfigAdic", query = "UPDATE ConfigAdicionalEntity SET estado = 'INACTIVO' WHERE id = :id")
})
public class ConfigAdicionalEntity extends Auditoria<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conf")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "configuracion")
	private ConfigAdicionalInf configuracion;
	
	@Column(name = "valor")
	private String valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_app", nullable = false)
	private AplicacionIntegraEntity aplicacion;

}
