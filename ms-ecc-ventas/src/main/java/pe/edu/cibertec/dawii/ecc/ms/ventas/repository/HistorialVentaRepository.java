package pe.edu.cibertec.dawii.ecc.ms.ventas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.HistorialVenta;

@Repository
public interface HistorialVentaRepository extends JpaRepository<HistorialVenta, Long>{
Optional<HistorialVenta> findByClienteId(Long clienteId);
}
