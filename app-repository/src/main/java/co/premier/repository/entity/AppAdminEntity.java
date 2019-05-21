package co.premier.repository.entity;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="app_admin", uniqueConstraints = {
		@UniqueConstraint(name = "UK_APPINTERNAS_CODIGO", columnNames = { "codigo" })
})
@Getter @Setter
@NamedQueries({
	@NamedQuery(name = "AppAdminEntity.borrarAppAdmin", query = "UPDATE AppAdminEntity a SET a.estado = 'INACTIVO' WHERE a.codigo = :codigo ")
})
public class AppAdminEntity extends Auditoria<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appadmin_generator")
	//El SequenceName hace referencia a una tabla en la base de datos el cual contiene un id que se toma como base para autoincrementar.
	@SequenceGenerator(name = "appadmin_generator", sequenceName = "appadmin_secuence", allocationSize = 1)
	@Column(name="id_app",  nullable = false, updatable = false)
	private Long id;
	@Column(name="codigo", nullable = false)
	private String codigo;	
	@Column(name="nombre")
	private String nombre;
	@Column(name ="numero_consumos")
	private BigInteger numeroConsumo;
	@OneToMany(mappedBy = "appAdmin", cascade = CascadeType.MERGE)
	private Set<UsuarioEntity> usuarios;
	
	public AppAdminEntity() {
	}	
}