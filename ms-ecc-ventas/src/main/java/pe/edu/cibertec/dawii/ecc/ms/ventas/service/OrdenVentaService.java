package pe.edu.cibertec.dawii.ecc.ms.ventas.service;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.OrdenVenta;

public interface OrdenVentaService {

	List<OrdenVenta> obtenerTodasOrdenes();

	Optional<OrdenVenta> obtenerOrdenPorId(Long idOrden);

	OrdenVenta crearOrdenVenta(OrdenVenta ordenVenta);

	Optional<OrdenVenta> actualizarOrdenVenta(OrdenVenta ordenVenta, Long idOrdenVenta);

	void eliminarOrdenVenta(Long idOrdenVenta);

}