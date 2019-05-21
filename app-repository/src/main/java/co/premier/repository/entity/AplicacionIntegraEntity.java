package co.premier.repository.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "app_aplicacion_integra")
@NamedQueries({
		@NamedQuery(name = "AplicacionIntegraEntity.buscarPorCodigo", query = "FROM AplicacionIntegraEntity appIntEntity LEFT JOIN FETCH appIntEntity.autenticaciones au LEFT JOIN appIntEntity.configuracionesAdic config LEFT JOIN appIntEntity.servicios service LEFT JOIN service.tipMetodo WHERE appIntEntity.codigo=:codigo"),
		@NamedQuery(name = "AplicacionIntegraEntity.buscarTodos", query = "FROM AplicacionIntegraEntity appIntEntity INNER JOIN FETCH appIntEntity.autenticaciones au "),
		@NamedQuery(name = "AplicacionIntegraEntity.borrarAplicacion",query = "UPDATE AplicacionIntegraEntity SET estado = 'INACTIVO' WHERE codigo = :codigo"),
		})
public class AplicacionIntegraEntity extends Auditoria<String> {

	@Id
	@Column(name = "id_app")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "codigo", unique = true)
	private String codigo;

	
	@OneToMany(mappedBy = "aplicacion", cascade = {CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.LAZY)
	private Set<AutenticacionEntity> autenticaciones;

	@OneToMany(mappedBy = "aplicacion", cascade = {CascadeType.REFRESH,CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<ConfigAdicionalEntity> configuracionesAdic;
	
	@OneToMany(mappedBy = "aplicacion", cascade = CascadeType.ALL ,orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<ServicioEntity> servicios;
}
