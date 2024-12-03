package pe.edu.cibertec.dawii.ecc.ms.ventas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
Optional<Pago> findByOrdenVentaId(Long ordenVentaId);
}
