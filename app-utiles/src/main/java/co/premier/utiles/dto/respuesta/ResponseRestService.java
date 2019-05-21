package co.premier.utiles.dto.respuesta;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ResponseRestService<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Variables usuadas para el envio de objetos en el caso que sea Extiso
	private T object;
	private List<T> listObject;
	private T[] vectorObject;
	private Integer code;

	private String method;
	private String uri;
	private String user;
	private String message;
	private String developerMessage;
	
	public ResponseRestService(T object) {
		super();
		this.object = object;
		this.code = 1;
	}

	public ResponseRestService(List<T> listObject) {
		super();
		this.listObject = listObject;
		this.code = 1;
	}
	
	public ResponseRestService(T[] vectorObject) {
		super();
		this.vectorObject = vectorObject;
	}

	public ResponseRestService(String method, String uri, String user, String message) {
		super();
		this.method = method;
		this.uri = uri;
		this.user = user;
		this.message = message;
		this.code = 2;
	}

}
