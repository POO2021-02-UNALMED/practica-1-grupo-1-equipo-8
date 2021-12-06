package gestorAplicacion.tienda;

import java.util.ArrayList;
import java.util.List;

public class Bodega {
	private static List<Componente> componentes;
	static {
		componentes = new ArrayList<Componente>();
	}
	
	public static void agregarComponente(Componente componente) {
		componentes.add(componente);	
	}
	/**
	 * 
	 * @param componente
	 * @summary Sacar componente recibe un componente y devuelve un componente con el mismo nombre que se encontraba en la Bodega, eliminándolo de la 
	 * lista de componentes de ésta.
	 * 
	 */
	
	public static Componente sacarComponente(Componente componente) {
		for (Componente componenteBodega:componentes) {
			if (componente.getNombre().equals(componenteBodega.getNombre())) {
				componentes.remove(componenteBodega);
				return componenteBodega;
			}
		}
	}
	public static List<Componente> getComponentes(){
		return componentes;
	}
}
