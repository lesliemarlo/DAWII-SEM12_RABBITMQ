package pe.edu.cibertec.dawii.ms.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ms.usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);
	

}


/*
 *  //8 mil millones
	
	//BigInteger //cualquier catidad
	long   // x trillones 
	int    // 2 mil 
	short  // 32000
	byte   // 128
	
	
	//BigDecimal //cualquier cantidad
	double  14
	float   7
 * /
 */