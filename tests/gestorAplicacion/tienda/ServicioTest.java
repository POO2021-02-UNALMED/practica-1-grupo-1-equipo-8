package gestorAplicacion.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;

class ServicioTest {

	@Test
	void test() {
		List<Componente> lista = new ArrayList<Componente>();
		lista.add(new Componente("display", false));
		lista.add(new Componente("puerto de carga", true));
		Producto producto = new Producto("Iphone", lista);
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		Bodega.agregarComponente(new Componente("puerto de carga", false, 50000));
		
		CajaRegistradora cajaRegistradora = new CajaRegistradora();
		Tecnico tecnico = new Tecnico("lol", 123);
		Dependiente dependiente = new Dependiente("Esteban", 123, cajaRegistradora);

		Cliente cliente = new Cliente("Felipe", "123456", listaProductos, dependiente, 100000);
		cliente.solicitarReparacion(producto);
		Servicio servicio = new Servicio(tecnico, producto, cliente, dependiente);
		Servicio servicio1 = new Servicio(tecnico, producto, cliente, dependiente);
		System.out.println(Servicio.getServicios().size());
		assertEquals(servicio.getIdentificador(), 0);
		assertEquals(servicio1.getIdentificador(), 1);
	}

}
