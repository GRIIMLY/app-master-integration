package co.premier.repository.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="app_roles", uniqueConstraints = {
		@UniqueConstraint(name = "UK_ROLREST_NOMBRE", columnNames = {"nombre"})
})
@Getter @Setter
@NamedQueries({
	@NamedQuery(name = "RolEntity.borrarRol", query = "UPDATE RolEntity r SET r.estado = 'INACTIVO' WHERE r.id = :id")
})
public class RolEntity extends Auditoria<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolerest_generator")
	//El SequenceName hace referencia a una tabla en la base de datos el cual contiene un id que se toma como base para autoincrementar.
	@SequenceGenerator(name = "rolerest_generator", sequenceName = "rol_secuence", allocationSize = 1)
	@Column(name="id_ro")
	private Long id;
	@NotNull(message="El nombre del role no puede ser nulo")
	@NotEmpty(message="El nombre del role no puede ser vacio")
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "rolesRest", fetch = FetchType.LAZY, cascade= {CascadeType.MERGE})
	private Set<UsuarioEntity> usuarios;
	
	public RolEntity() {
	}	
}