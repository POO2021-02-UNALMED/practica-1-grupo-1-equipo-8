package gestorAplicacion.personal;
import java.util.*;
import gestorAplicacion.tienda.*;

/**
 * 
 * @author Emilio Porras
 * @summary Esta clase busca representar el comportamiento de un empleado tipo t�cnico
 * Estructuras relevantes: servicios es una lista de servicios que se va modificando a medida que el t�cnico toma o finaliza servicios
 *
*/

public class Tecnico extends Empleado {
	
	public Tecnico(String nombre, int cedula, List<Servicio> servicios) {
		super(nombre, cedula, servicios);
	}
	
	public Tecnico(String nombre, int cedula) {
		super(nombre, cedula);
	}

	/**
	 * 
	 * @param servicio
	 * @summary El m�todo verificarProblemas es un m�todo auxiliar de la clase, el cual recibe un servicio y devuelve una lista con los componentes
	 * da�ados en el producto correspondiente a ese servicio
	 * 
	 */
	private List<Componente> verificarProblemas(Servicio servicio){
		Producto producto = servicio.getProducto();
		List<Componente> averiados = new ArrayList<Componente>();
		for (Componente componente : producto.getComponentes()) {
			if (componente.isAveriado()) {
				averiados.add(componente);
			}
		}
		return averiados;
	}
	/**
	 * 
	 * @param componente
	 * @summary El m�todo buscarComponente es un m�todo auxiliar de la clase, el cual recibe un componente y devuelve booleano dependiendo de si un componente
	 * con el mismo nombre se encuentra en la Bodega o no.
	 * 
	 */
	private boolean buscarComponente(Componente componente) {
		List<Componente> componentes = Bodega.getComponentes();
		for(Componente componenteBodega: componentes) {
			if (componente.getNombre().equals(componenteBodega.getNombre())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param servicio
	 * @summary El m�todo diagnosticar recibe como par�metro un servicio y modifica en �l su atributo diagn�stico, brindando informaci�n 
	 * sobre los problemas del producto correspondiente.
	 *  
	 */
	public void diagnosticar(Servicio servicio) {
		servicio.setDiagnostico("Se encontraron problemas en los siguientes componentes del producto: "+ verificarProblemas(servicio));
	}
	/**
	 * 
	 * @param servicio
	 * @summary El m�todo reparar recibe como par�metro un servicio. Luego, revisa si los componentes da�ados est�n disponibles en la bodega y, a 
	 * aquellos que est�n disponibles, los remueve de la lista de Bodega y los reemplaza en la lista de componentes del producto.
	 * 
	 */
	public void reparar(Servicio servicio) {
		Producto producto = servicio.getProducto();
		List<Componente> averiados = verificarProblemas(servicio);
		for (Componente componente: averiados) {
			if (buscarComponente(componente)) {
				producto.quitarComponente(componente);
				producto.agregarComponente(Bodega.sacarComponente(componente));
			}
		}
	}
	/**
	 * 
	 * @param servicio
	 * @summary El m�todo asignarServicio recibe como par�metro un servicio y lo agrega a la lista de servicios del t�cnico en cuesti�n.
	 * 
	 */
	public void asignarServicio(Servicio servicio) {
		servicios.add(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El m�todo quitarServicio recibe como par�metro un servicio y lo remueve de la lista de servicios del t�cnico en cuesti�n.
	 * 
	 */
	public void quitarServicio(Servicio servicio) {
		servicios.remove(servicio);
	}
	
	public void notificarDependiente() {
		;
	}
	
}
