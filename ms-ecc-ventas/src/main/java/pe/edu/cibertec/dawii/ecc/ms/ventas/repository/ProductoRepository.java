package pe.edu.cibertec.dawii.ecc.ms.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	Optional<Producto> findBySku(String sku);
	List<Producto> findByActivoTrue();
}
