package ec2.plasencia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BODEGA")
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	private String nombre;
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	
	public Bodega() {
		// TODO Auto-generated constructor stub
	}

	public Bodega(Integer idBodega, String nombre, String direccion) {
		this.idBodega = idBodega;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Integer getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(Integer idBodega) {
		this.idBodega = idBodega;
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
	
}
