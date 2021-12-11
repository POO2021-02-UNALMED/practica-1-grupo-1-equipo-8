package gestorAplicacion.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BodegaTest {

	@Test
	void agregarYSacarComponente() {
		Componente componente = new Componente("display", false);
		componente.setNombre("memoria");
		Bodega.agregarComponente(componente);
		assertEquals(componente, Bodega.sacarComponente("memoria"));
	}
	
	@Test
	void sacaComponenteQueNoExiste() {
		Componente componente = new Componente("display", false);
		componente.setNombre("mm");
		assertNull(Bodega.sacarComponente("mm"));
	}
}
