package pe.edu.cibertec.dawii.ecc.ms.ventas.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "detalle_orden")
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indicar que serà autogenerado el campo
	private Long id;
	@Column(nullable = false)
	private Integer cantidad;
	@Column(name= "precio_unitario",nullable = false, precision = 10, scale = 2)
	private BigDecimal precioUnitario;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal subtotal;

	@ManyToOne
	@JoinColumn(name = "orden_venta_id", nullable = false)
	private OrdenVenta ordenVenta;
	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

}
