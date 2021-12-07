package gestorAplicacion.personal;
import java.util.*;
import gestorAplicacion.tienda.*;

/**
 * 
 * @author Emilio Porras
 * @summary Esta clase busca representar el comportamiento de un empleado tipo técnico
 * Estructuras relevantes: servicios es una lista de servicios que se va modificando a medida que el técnico toma o finaliza servicios
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
	 * @summary El método verificarProblemas es un método auxiliar de la clase, el cual recibe un servicio y devuelve una lista con los componentes
	 * dañados en el producto correspondiente a ese servicio
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
	 * @summary El método buscarComponente es un método auxiliar de la clase, el cual recibe un componente y devuelve booleano dependiendo de si un componente
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
	 * @summary El método diagnosticar recibe como parámetro un servicio y modifica en él su atributo diagnóstico, brindando información 
	 * sobre los problemas del producto correspondiente.
	 *  
	 */
	public void diagnosticar(Servicio servicio) {
		servicio.setDiagnostico("Se encontraron problemas en los siguientes componentes del producto: "+ verificarProblemas(servicio));
	}
	/**
	 * 
	 * @param servicio
	 * @summary El método reparar recibe como parámetro un servicio. Luego, revisa si los componentes dañados están disponibles en la bodega y, a 
	 * aquellos que estén disponibles, los remueve de la lista de Bodega y los reemplaza en la lista de componentes del producto.
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
	 * @summary El método asignarServicio recibe como parámetro un servicio y lo agrega a la lista de servicios del técnico en cuestión.
	 * 
	 */
	public void asignarServicio(Servicio servicio) {
		servicios.add(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El método quitarServicio recibe como parámetro un servicio y lo remueve de la lista de servicios del técnico en cuestión.
	 * 
	 */
	public void quitarServicio(Servicio servicio) {
		servicios.remove(servicio);
	}
	
	public void notificarDependiente() {
		;
	}
	
}
