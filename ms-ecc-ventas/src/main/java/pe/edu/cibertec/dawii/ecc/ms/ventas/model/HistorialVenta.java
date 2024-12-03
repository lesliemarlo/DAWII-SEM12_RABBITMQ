package pe.edu.cibertec.dawii.ecc.ms.ventas.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historial_venta")
@NoArgsConstructor
@AllArgsConstructor
public class HistorialVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indicar que serà autogenerado el campo
	private Long id;

	@Column(nullable = false)
	private Long clienteId;

	@OneToMany
	@JoinColumn(name = "cliente_id", referencedColumnName = "clienteId",
			insertable = false, updatable = false)
	private List<OrdenVenta> detalles;

}