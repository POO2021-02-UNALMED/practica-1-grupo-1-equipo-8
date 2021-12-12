package gestorAplicacion.tienda;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;
import gestorAplicacion.tienda.Bodega;

class Funcionalides {

	@Test
	void diagnosticar() {
		List<Componente> lista = new ArrayList<Componente>();
		lista.add(new Componente("display", false));
		lista.add(new Componente("puerto de carga", true));
		Producto producto = new Producto("Iphone", "celular", lista);
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		CajaRegistradora cajaRegistradora = new CajaRegistradora();
		
		Dependiente dependiente = new Dependiente("Esteban", 123, cajaRegistradora);

		Cliente cliente = new Cliente("Felipe", "123456", listaProductos, dependiente, 100000);
		cliente.solicitarReparacion(producto);
		
		Tecnico.tecnicos.get(0).diagnosticar(dependiente.getServicios().get(0));
		
		assertEquals("Se encontraron problemas en los siguientes componentes del producto: [puerto de carga]", dependiente.getServicios().get(0).getDiagnostico());
	}
	
	@Test
	void reparar() {
		List<Componente> lista = new ArrayList<Componente>();
		lista.add(new Componente("display", false));
		lista.add(new Componente("puerto de carga", true));
		Producto producto = new Producto("Iphone", "celular", lista);
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		Bodega.agregarComponente(new Componente("puerto de carga", false, 50000));
		
		CajaRegistradora cajaRegistradora = new CajaRegistradora();
		
		Dependiente dependiente = new Dependiente("Esteban", 123, cajaRegistradora);

		Cliente cliente = new Cliente("Felipe", "123456", listaProductos, dependiente, 100000);
		cliente.solicitarReparacion(producto);
		Servicio servicio = dependiente.getServicios().get(0);
		Tecnico.tecnicos.get(0).reparar(servicio);
		
		assertTrue(!producto.getComponentes().get(1).isAveriado());
		assertEquals(50000, servicio.getCosto());
		assertEquals(0, Bodega.getComponentes().size());
	}
	
	
}
