package pe.edu.cibertec.dawii.ecc.ms.ventas.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indicar que serà autogenerado el campo
	private Long id;

	@Column(nullable = false, unique = true, length = 30)

	private String sku;

	@Column(nullable = false, length = 100)

	private String nombre;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;

	@Column(nullable = false)
	private Boolean activo;

}
