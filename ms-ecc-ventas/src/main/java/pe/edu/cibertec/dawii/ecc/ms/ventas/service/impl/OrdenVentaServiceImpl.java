package pe.edu.cibertec.dawii.ecc.ms.ventas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.OrdenVenta;
import pe.edu.cibertec.dawii.ecc.ms.ventas.repository.OrdenVentaRepository;
import pe.edu.cibertec.dawii.ecc.ms.ventas.service.OrdenVentaService;

@Service
public class OrdenVentaServiceImpl implements OrdenVentaService{

	@Autowired
	private OrdenVentaRepository ordenVentaReporsitory;
	//--
	@Override
	public List<OrdenVenta> obtenerTodasOrdenes() {
		return ordenVentaReporsitory.findAll();
	}

	@Override
	public Optional<OrdenVenta> obtenerOrdenPorId(Long idOrden) {
		return ordenVentaReporsitory.findById(idOrden);
	}

	@Override
	public OrdenVenta crearOrdenVenta(OrdenVenta ordenVenta) {
		ordenVenta.setFecha(LocalDateTime.now()); //capturamos la fecha de AHORA
		return ordenVentaReporsitory.save(ordenVenta);
	}

	@Override
	public Optional<OrdenVenta> actualizarOrdenVenta(OrdenVenta ordenVenta, Long idOrdenVenta) {
		Optional<OrdenVenta> ordenVentaEncontrado = ordenVentaReporsitory.findById(idOrdenVenta);
		return ordenVentaEncontrado.map(ordenVentaExistente -> {
			ordenVentaExistente.setEstado(ordenVenta.getEstado());
			ordenVentaExistente.setFecha(ordenVenta.getFecha());
			return ordenVentaReporsitory.save(ordenVentaExistente);
		});
	}

	@Override
	public void eliminarOrdenVenta(Long idOrdenVenta) {
		ordenVentaReporsitory.deleteById(idOrdenVenta);	
	}

}
