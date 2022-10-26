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

import ec2.plasencia.service.BodegaService;
import ec2.plasencia.entity.Bodega;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaController {

	@Autowired
	private BodegaService service;
	
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Bodega>> getBodegas(){
		return new ResponseEntity<List<Bodega>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Bodega> insertarBodega(@RequestBody Bodega bodega) {
		Bodega savedBodega = service.guardar(bodega);
		return new ResponseEntity<Bodega>(savedBodega, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Bodega> actualizarBodega(@RequestBody Bodega bodega) {
		Bodega updatedBodega = service.actualizar(bodega);
		return new ResponseEntity<Bodega>(updatedBodega, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path = "/delete/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Bodega> eliminarBodega(@PathVariable int codigo) {
		Bodega deletedBodega = service.eliminar(codigo);
		return new ResponseEntity<Bodega>(deletedBodega, HttpStatus.OK);
	}
}
