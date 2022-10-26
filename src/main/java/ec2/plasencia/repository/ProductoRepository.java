package ec2.plasencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec2.plasencia.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
