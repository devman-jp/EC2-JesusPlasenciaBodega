package ec2.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec2.plasencia.entity.Bodega;
import ec2.plasencia.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository repository;
	
	@Override
	public List<Bodega> lista() {
		return repository.findAll();
	}

	@Override
	public Bodega obtener(Integer idBodega) {
		return repository.findById(idBodega).orElse(null);
	}

	@Override
	public Bodega guardar(Bodega bodega) {
		if(bodega.getIdBodega() != null) {
			return null;
		}
		Bodega validateBodega = validarBodega(bodega);
		repository.save(validateBodega);
		List<Bodega> listadoBodegas = lista();
		return listadoBodegas.get(listadoBodegas.size() - 1);
	}

	@Override
	public Bodega actualizar(Bodega bodega) {
		if(bodega.getIdBodega() == null) {
			return null;
		}
		Bodega findBodega = obtener(bodega.getIdBodega());
		if(findBodega == null) {
			return null;
		}
		Bodega validateBodega = validarBodega(bodega);
		findBodega.setNombre(validateBodega.getNombre());
		findBodega.setDireccion(validateBodega.getDireccion());
		repository.saveAndFlush(findBodega);
		return findBodega;
	}

	@Override
	public Bodega eliminar(Integer idBodega) {
		Bodega findBodega = obtener(idBodega);
		if(findBodega == null) {
			return null;
		}
		repository.deleteById(idBodega);
		return findBodega;
	}
	
	public Bodega validarBodega(Bodega bodega) {
		if(bodega.getDireccion().length() == 0 || bodega.getDireccion().length() < 3) {
			return null;
		}
		if(bodega.getNombre().length() == 0 || bodega.getNombre().length() < 3) {
			return null;
		}
		return bodega;
	}

}
