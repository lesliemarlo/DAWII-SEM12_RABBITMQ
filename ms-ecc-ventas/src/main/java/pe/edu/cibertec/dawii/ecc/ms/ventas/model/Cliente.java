package pe.edu.cibertec.dawii.ecc.ms.ventas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // marcar a la clase como una entidad JPA
@Table(name = "cliente")
@Data // set y get + toString + equals + hashcode
@NoArgsConstructor // agregar un constructor sin paràmetros
@AllArgsConstructor // agregar un constructor con paràmetros
public class Cliente {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY) // indicar que serà autogenerado el campo
	private Long id;
	@Column(nullable = false, length = 100)
	String nombre;
	@Column(nullable = false, unique = true, length = 40)
	String email;
	@Column(nullable = false, length = 15)
	String telefono;
	@Column(nullable = false, length = 200)
	String direccion;
}
