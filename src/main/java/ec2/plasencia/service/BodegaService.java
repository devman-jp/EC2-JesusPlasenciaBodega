package ec2.plasencia.service;

import java.util.List;

import ec2.plasencia.entity.Bodega;

public interface BodegaService {

	List<Bodega> lista();
	Bodega obtener(Integer idBodega);
	Bodega guardar(Bodega bodega);
	Bodega actualizar(Bodega bodega);
	Bodega eliminar(Integer idBodega);
	
}
