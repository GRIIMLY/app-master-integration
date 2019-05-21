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

import co.premier.repository.enumeracion.TipoAutInt;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "app_autenticacion")
@NamedQueries({
	@NamedQuery(name = "AutenticacionEntity.borrarAutenticacion",query = "UPDATE AutenticacionEntity SET estado = 'INACTIVO' WHERE id = :id"),
})
public class AutenticacionEntity extends Auditoria<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoAutInt tipo;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name =  "contrasenia")
	private String contrasenia;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_app", nullable = false)
	private AplicacionIntegraEntity aplicacion;

}
