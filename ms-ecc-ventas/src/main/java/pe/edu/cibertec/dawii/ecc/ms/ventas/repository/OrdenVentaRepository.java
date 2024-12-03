package pe.edu.cibertec.dawii.ecc.ms.ventas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.Cliente;
import pe.edu.cibertec.dawii.ecc.ms.ventas.model.OrdenVenta;

@Repository

public interface OrdenVentaRepository extends JpaRepository<OrdenVenta, Long> {

	public Optional<Cliente> findByClienteId(Long clienteId);

}
