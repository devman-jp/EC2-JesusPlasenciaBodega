package ec2.plasencia.service;

import java.util.List;

import ec2.plasencia.entity.Cliente;

public interface ClienteService {

	List<Cliente> lista();
	Cliente obtener(Integer idCliente);
	Cliente guardar(Cliente cliente);
	Cliente actualizar(Cliente cliente);
	Cliente eliminar(Integer idCliente);
	
}
