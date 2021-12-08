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
	 * @summary Sacar componente recibe un componente y devuelve un componente con el mismo nombre que se encontraba en la Bodega, elimin�ndolo de la 
	 * lista de componentes de �sta.
	 * 
	 */
	public static Componente sacarComponente(String nombreComponente) {
		for (Componente componente: componentes) {
			if (componente.getNombre().equals(nombreComponente)) {
				componentes.remove(componente);
				return componente;
			}
		}
		return null;
	}
	public static List<Componente> getComponentes(){
		return componentes;
	}
}