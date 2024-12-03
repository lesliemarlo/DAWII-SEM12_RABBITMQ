package pe.edu.cibertec.dawii.ecc.ms.ventas.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	

@Table(name = "pago")

@Data	

@NoArgsConstructor

@AllArgsConstructor

public class Pago {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	@Column(name = "fecha_pago", nullable = false)
	private LocalDateTime fechaPago;

	@Column(name = "monto_pago",nullable = false, precision = 10, scale = 2)
	private BigDecimal montoPago;

	@Column(name = "metodo_pago", nullable = false, length = 20)
	private String metodoPago;

	@Column(nullable = false, length = 20)
	private String estado;


	@OneToOne
	@JoinColumn(name = "orden_venta_id", nullable = false)
	private OrdenVenta ordenVenta;


}