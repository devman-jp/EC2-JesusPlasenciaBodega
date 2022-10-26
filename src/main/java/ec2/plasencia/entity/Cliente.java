package ec2.plasencia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private String direccion;
	private Integer dni;
	
	@ManyToMany(mappedBy = "clientes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Producto> productos = new ArrayList<>();
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, String nombre, String direccion, Integer dni) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
}
