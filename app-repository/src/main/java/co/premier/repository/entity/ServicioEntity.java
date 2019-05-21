package co.premier.repository.entity;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.premier.repository.enumeracion.TipoServicioInt;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "app_servicio")
@NamedQueries(@NamedQuery(name="ServicioEntity.borarEntidad",query = "UPDATE ServicioEntity SET estado = 'INACTIVO' WHERE id = :id"))
public class ServicioEntity extends Auditoria<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_serv")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "url")
	private String url;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoServicioInt tipo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull(message =  "Por favor ingrese una aplicacion")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_app",nullable = false)
	private AplicacionIntegraEntity aplicacion;
	
	@OneToOne(mappedBy = "servicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private TipoMetodoEntity tipMetodo;
	
	
}
