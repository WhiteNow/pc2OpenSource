package pe.edu.upc.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellido;
	
	@NotNull
	private String dni;
	
	@NotNull
	@Length(max=4, min=4)
	private String clave;
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Cuenta> cuentas;
	
	public Cliente() {
		this.cuentas=new ArrayList<>();
	}

	
	
	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	

}
