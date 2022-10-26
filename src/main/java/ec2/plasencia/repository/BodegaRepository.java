package ec2.plasencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec2.plasencia.entity.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

}
