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
	
	public static Componente sacarComponente(Componente componente) {
		int index = componentes.indexOf(componente);
		if (index >= 0) {
			return componentes.remove(index);
		}
		return null;
	}
	public static List<Componente> getComponentes(){
		return componentes;
	}
}
