package pe.edu.cibertec.dawii.ecc.ms.ventas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.dawii.ecc.ms.ventas.model.OrdenVenta;
import pe.edu.cibertec.dawii.ecc.ms.ventas.service.OrdenVentaService;

@RestController
@RequestMapping("/api/ordenes-venta")
public class OrdenVentaRestController {
	
	@Autowired
	private OrdenVentaService ordenVentaService;
	
	//--
	@GetMapping 
	public List<OrdenVenta> listarrdenesVenta(){
		return ordenVentaService.obtenerTodasOrdenes()
;	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdenVenta> obtenerVentaPorId(@PathVariable Long id){
		Optional<OrdenVenta> ordenVenta = ordenVentaService.obtenerOrdenPorId(id);
		return ordenVenta
				.map(ResponseEntity::ok)  // 200 en caso de encontrar
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
	}
	
	@PostMapping
	public OrdenVenta crearOrdenVenta(@RequestBody OrdenVenta ordenVenta) {
		return ordenVentaService.crearOrdenVenta(ordenVenta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrdenVenta> actualizarOrdenVenta(@PathVariable Long id, @RequestBody OrdenVenta ordenVenta) {
		Optional<OrdenVenta> ordenVentaActualizada = ordenVentaService.actualizarOrdenVenta(ordenVenta, id);
		 return ordenVentaActualizada
					.map(ResponseEntity::ok)  // 200 en caso de encontrar
					.orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
	}

	

	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarOrdenVenta(@PathVariable Long id) {
		ordenVentaService.eliminarOrdenVenta(id);
	return ResponseEntity.noContent().build();

	}

}
