package pe.edu.cibertec.dawii.ecc.ms.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.DetalleOrden;
import pe.edu.cibertec.dawii.ecc.ms.ventas.model.OrdenVenta;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long>{
	List<DetalleOrden> findByOrdenVentaId(Long ordenVentaId);
}
