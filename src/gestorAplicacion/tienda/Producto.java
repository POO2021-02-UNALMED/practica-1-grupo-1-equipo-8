package gestorAplicacion.tienda;
import java.util.*;

/**
 * 
 * @author Emilio Porras
 * @summary Esta clase busca representar el comportamiento de un producto tra�do a la tienda por un cliente, el cual espera sea reparado.
 * Estructuras relevantes: componentes corresponde a la lista de todos los componentes que conforman el producto, pueden estar a veriados o no.
 *
*/
public class Producto {
	private String nombre;
	private String tipo;
	private List<Componente> componentes;
	
	public Producto(String nombre, String tipo, List<Componente> componentes) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.componentes = componentes;
	}
	/**
	 * 
	 * @param componente
	 * @summary El m�todo agregarComponente recibe como par�metro un componente y lo agrega a la lista de componentes del producto.
	 * 
	 */
	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}
	/**
	 * 
	 * @param componente
	 * @summary El m�todo quitarComponente recibe como par�metro un componente y lo quita de la lista de componentes del producto.
	 * 
	 */
	public void quitarComponente(Componente componente) {
		componentes.remove(componente);
	}

	public List<Componente> getComponentes() {
		return componentes;
	}
	
	public String toString() {
		return this.nombre + " de tipo " + this.tipo;
	}
	
}
