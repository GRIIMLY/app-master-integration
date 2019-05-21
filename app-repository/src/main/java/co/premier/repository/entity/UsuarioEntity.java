package co.premier.repository.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_usuarios", uniqueConstraints = {
		@UniqueConstraint(name = "UK_USUARIO_USUARIO", columnNames = { "usuario" }),
		@UniqueConstraint(name = "UK_USUARIO_CODIGO", columnNames = { "codigo" })
})
@NamedQueries({
		@NamedQuery(name = "UsuarioEntity.obtenerTodosUsuarios", query = "select distinct u from UsuarioEntity u inner join fetch u.rolesRest rol"),
		@NamedQuery(name = "UsuarioEntity.authenticateUser", query = "select usuarioEntity from UsuarioEntity usuarioEntity where usuarioEntity.usuario = :usuario and usuarioEntity.contrasena = :contrasena  "),
		@NamedQuery(name = "UsuarioEntity.borrarUsuario", query = "UPDATE UsuarioEntity u SET u.estado = 'INACTIVO' WHERE u.codigo = :codigo ") })
@Getter
@Setter
public class UsuarioEntity extends Auditoria<String> {
	@Id
	@Column(name = "id_us", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_seq", allocationSize = 1)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "usuario")
	private String usuario;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "contrasena")
	private String contrasena;
	@Column(name = "codigo", nullable = false)
	private String codigo;
	@Column(name = "nombre")
	private String nombre;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "app_admin_fk", referencedColumnName = "id_app")
	private AppAdminEntity appAdmin;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "usuario_as_roles", joinColumns = @JoinColumn(name = "id_us"), inverseJoinColumns = @JoinColumn(name = "id_ro"))
	private Set<RolEntity> rolesRest;

	public UsuarioEntity() {
		super();
	}

}