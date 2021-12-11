package gestorAplicacion.tienda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import gestorAplicacion.personal.Dependiente;

class Funcionalides {

	@Test
	void x() {
		List<Componente> lista = new ArrayList<Componente>();
		lista.add(new Componente("display", false));
		lista.add(new Componente("puerto de carga", true));
		Producto producto = new Producto("Iphone", "celular", lista);
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		CajaRegistradora cajaRegistradora = new CajaRegistradora();
		
		Dependiente dependiente = new Dependiente("Esteban", 123, cajaRegistradora);

		Cliente cliente = new Cliente("Felipe", "123456", listaProductos, dependiente);
		cliente.solicitarReparacion(producto);
		
	}
}
