package ec2.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec2.plasencia.entity.Cliente;
import ec2.plasencia.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> lista() {
		return repository.findAll();
	}

	@Override
	public Cliente obtener(Integer idCliente) {
		return repository.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		if(cliente.getIdCliente() != null) {
			return null;
		}
		Cliente validateCliente = validarCliente(cliente);
		repository.save(validateCliente);
		List<Cliente> listadoClientes = lista();
		return listadoClientes.get(listadoClientes.size() - 1);
	}

	@Override
	public Cliente actualizar(Cliente cliente) {
		if(cliente.getIdCliente() == null) {
			return null;
		}
		Cliente findCliente = obtener(cliente.getIdCliente());
		if(findCliente == null) {
			return null;
		}
		Cliente validateCliente = validarCliente(cliente);
		findCliente.setNombre(validateCliente.getNombre());
		findCliente.setDireccion(validateCliente.getDireccion());
		findCliente.setDni(validateCliente.getDni());
		repository.saveAndFlush(findCliente);
		return findCliente;
	}

	@Override
	public Cliente eliminar(Integer idCliente) {
		Cliente findCliente = obtener(idCliente);
		if(findCliente == null) {
			return null;
		}
		repository.deleteById(idCliente);
		return findCliente;
	}
	
	public Cliente validarCliente(Cliente cliente) {
		if(cliente.getDni() <= 0 || cliente.getDni().toString().length() == 0) {
			return null;
		}
		if(cliente.getDireccion().length() == 0 || cliente.getDireccion().length() < 3) {
			return null;
		}
		if(cliente.getNombre().length() == 0 || cliente.getNombre().length() < 3) {
			return null;
		}
		return cliente;
	}

}
