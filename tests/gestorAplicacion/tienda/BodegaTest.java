package gestorAplicacion.tienda;
import java.util.*;

import static org.junit.Assert.assertTrue;
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
	
	@Test
	void retornaYNoElimina() {
		Bodega.setComponentes(new ArrayList<Componente>());
		Componente componente = new Componente("display", false);
		Bodega.agregarComponente(componente);
		Bodega.sacarComponente("display");
		assertEquals(Bodega.getComponentes().size(), 1);
		}
	
	@Test
	void retornaYElimina() {
		Bodega.setComponentes(new ArrayList<Componente>());
		Componente componente = new Componente("display", false);
		Bodega.agregarComponente(componente);
		Bodega.sacarComponente(componente);
		assertEquals(Bodega.getComponentes().size(), 0);
	}
	
	@Test
	void buscarComponente() {
		Bodega.setComponentes(new ArrayList<Componente>());
		Componente componente = new Componente("display", false);
		Bodega.agregarComponente(componente);
		assertTrue(Bodega.sacarComponente("display") != null);
		assertTrue(Bodega.sacarComponente("test") == null);
	}
}
