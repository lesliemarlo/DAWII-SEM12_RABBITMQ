package pe.edu.cibertec.dawii.ecc.ms.ventas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
 Optional<Cliente> findByEmail(String email);
}
