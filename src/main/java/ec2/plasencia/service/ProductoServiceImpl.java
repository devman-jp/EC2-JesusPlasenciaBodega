package ec2.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec2.plasencia.entity.Producto;
import ec2.plasencia.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> lista() {
		return repository.findAll();
	}

	@Override
	public Producto obtener(Integer idProducto) {
		return repository.findById(idProducto).orElse(null);
	}

	@Override
	public Producto guardar(Producto producto) {
		if(producto.getIdProducto() != null) {
			return null;
		}
		Producto validateProducto = validarProducto(producto);
		repository.save(validateProducto);
		List<Producto> listadoProductos = lista();
		return listadoProductos.get(listadoProductos.size() - 1);
	}

	@Override
	public Producto actualizar(Producto producto) {
		if(producto.getIdProducto() == null) {
			return null;
		}
		Producto findProducto = obtener(producto.getIdProducto());
		if(findProducto == null) {
			return null;
		}
		Producto validateProducto = validarProducto(producto);
		findProducto.setProducto(validateProducto.getProducto());
		findProducto.setDescripcion(validateProducto.getDescripcion());
		findProducto.setPrecio(validateProducto.getPrecio());
		findProducto.setStock(validateProducto.getStock());
		repository.saveAndFlush(findProducto);
		return findProducto;
	}

	@Override
	public Producto eliminar(Integer idProducto) {
		Producto findProducto = obtener(idProducto);
		if(findProducto == null) {
			return null;
		}
		repository.deleteById(idProducto);
		return findProducto;
	}
	
	public Producto validarProducto(Producto producto) {
		if(producto.getPrecio() <= 0 || producto.getStock() <= 0) {
			return null;
		}
		if(producto.getDescripcion().length() == 0 || producto.getDescripcion().length() < 3) {
			return null;
		}
		if(producto.getProducto().length() == 0 || producto.getProducto().length() < 3) {
			return null;
		}
		return producto;
	}

	
}
