package pe.edu.cibertec.dawii.ecc.ms.ventas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	

@Table(name = "orden_venta")

@Data	

@NoArgsConstructor

@AllArgsConstructor

public class OrdenVenta {



	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;



	@Column(nullable = false)

	private LocalDateTime fecha;

	@Column(nullable = false, length = 20)

	private String estado;



	@Column(name = "monto_total", nullable = false, precision = 10, scale = 2)

	private BigDecimal montoTotal;



	//cliente

	@ManyToOne

	@JoinColumn(name = "cliente_id", nullable = false)

	private Cliente cliente;

	



	//Detalles de venta

	@OneToMany(mappedBy = "ordenVenta", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<DetalleOrden> detalles;

}