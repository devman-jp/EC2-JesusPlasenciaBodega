package ec2.plasencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec2.plasencia.entity.Producto;
import ec2.plasencia.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getProductos(){
		return new ResponseEntity<List<Producto>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Producto> insertarProducto(@RequestBody Producto producto) {
		Producto savedProducto = service.guardar(producto);
		return new ResponseEntity<Producto>(savedProducto, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
		Producto updatedProducto = service.actualizar(producto);
		return new ResponseEntity<Producto>(updatedProducto, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path = "/delete/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Producto> eliminarProducto(@PathVariable int codigo) {
		Producto deletedProducto = service.eliminar(codigo);
		return new ResponseEntity<Producto>(deletedProducto, HttpStatus.OK);
	}
}
