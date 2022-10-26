package ec2.plasencia.service;

import java.util.List;

import ec2.plasencia.entity.Producto;

public interface ProductoService {

	List<Producto> lista();
	Producto obtener(Integer idProducto);
	Producto guardar(Producto producto);
	Producto actualizar(Producto producto);
	Producto eliminar(Integer idProducto);
	
}
