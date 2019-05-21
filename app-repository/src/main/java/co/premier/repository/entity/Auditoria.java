package co.premier.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import co.premier.repository.enumeracion.EstadoApp;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditoria<U> {

	@CreatedBy
    @Column(name = "created_by", updatable = false)
    private U createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    
    @NotNull(message = "El estado de la entidad no puede ser nulo")
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private EstadoApp estado;
}
