package gestorAplicacion.tienda;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Emilio Porras
 * @summary Esta clase busca representar el comportamiento de un producto traido a la tienda por un cliente, el cual espera sea reparado.
 * Estructuras relevantes: componentes corresponde a la lista de todos los componentes que conforman el producto, pueden estar averiados o no.
 *
*/
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Componente> componentes;
	
	public static List<Producto> productos;
	
	static {
		productos = new ArrayList<Producto>();
	}
	
	public Producto(String nombre, List<Componente> componentes) {
		super();
		this.nombre = nombre;
		this.componentes = componentes;
		productos.add(this);
	}
	
	/**
	 * 
	 * @param componente
	 * @summary El metodo agregarComponente recibe como parametro un componente y lo agrega a la lista de componentes del producto.
	 * 
	 */
	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}
	
	/**
	 * 
	 * @param componente
	 * @summary El metodo quitarComponente recibe como parametro un componente y lo quita de la lista de componentes del producto.
	 * 
	 */
	public void quitarComponente(Componente componente) {
		componentes.remove(componente);
	}

	public List<Componente> getComponentes() {
		return componentes;
	}
	
	public String toString() {
		return this.nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
