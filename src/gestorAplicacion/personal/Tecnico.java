package gestorAplicacion.personal;
import java.util.*;
import gestorAplicacion.tienda.*;

/**
 * 
 * @author Emilio Porras
 * Finalidad: Esta clase busca representar el comportamiento de un empleado tipo técnico
 * Estructuras relevantes: servicios es una lista de servicios que se va modificando a medida que el técnico toma o finaliza servicios
 *
*/

public class Tecnico extends Empleado {
	private String nombre;
	private List<Servicio> servicios = new ArrayList<Servicio>();
	
	public Tecnico(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Tecnico(String nombre, List<Servicio> servicios) {
		super();
		this.nombre = nombre;
		this.servicios = servicios;
	}
	/**
	 * 
	 * @param servicio
	 * @summary El método verificarProblemas es un método auxiliar de la clase, el cual recibe un servicio y devuelve una lista con los componentes
	 * dañados en el producto correspondiente a ese servicio
	 * 
	 */
	private List<Componente> verificarProblemas(Servicio servicio){
		producto = servicio.getProducto();
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
	 * @summary El método buscarComponente es un método auxiliar de la clase, el cual recibe un componente y devuelve booleano dependiendo de si éste
	 * se encuentra en la lista componentes de Bodega o no.
	 * 
	 */
	private boolean buscarComponente(Componente componente) {
		return Bodega.getComponentes().contains(componente);
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
		
	}
}
