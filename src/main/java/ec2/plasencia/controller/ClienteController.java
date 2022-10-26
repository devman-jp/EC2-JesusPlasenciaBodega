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

import ec2.plasencia.entity.Cliente;
import ec2.plasencia.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getClientes(){
		return new ResponseEntity<List<Cliente>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
		Cliente savedCliente = service.guardar(cliente);
		return new ResponseEntity<Cliente>(savedCliente, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
		Cliente updatedCliente = service.actualizar(cliente);
		return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path = "/delete/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> eliminarCliente(@PathVariable int codigo) {
		Cliente deletedCliente = service.eliminar(codigo);
		return new ResponseEntity<Cliente>(deletedCliente, HttpStatus.OK);
	}
}
