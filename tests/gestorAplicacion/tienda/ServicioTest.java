package gestorAplicacion.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ServicioTest {

	@Test
	void test() {
		Servicio servicio = new Servicio();
		assertEquals(servicio.getIdentificador(), 0);
		servicio = new Servicio();
		assertEquals(servicio.getIdentificador(), 1);
	}

}
