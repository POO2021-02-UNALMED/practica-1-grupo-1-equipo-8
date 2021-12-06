package gestorAplicacion.personal;
import java.util.*;
import gestorAplicacion.tienda.*;

/**
 * 
 * @author Emilio Porras
 * Finalidad: Esta clase busca representar el comportamiento de un empleado tipo t�cnico
 * Estructuras relevantes: servicios es una lista de servicios que se va modificando a medida que el t�cnico toma o finaliza servicios
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
	 * @summary El m�todo verificarProblemas es un m�todo auxiliar de la clase, el cual recibe un servicio y devuelve una lista con los componentes
	 * da�ados en el producto correspondiente a ese servicio
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
	 * @summary El m�todo buscarComponente es un m�todo auxiliar de la clase, el cual recibe un componente y devuelve booleano dependiendo de si �ste
	 * se encuentra en la lista componentes de Bodega o no.
	 * 
	 */
	private boolean buscarComponente(Componente componente) {
		return Bodega.getComponentes().contains(componente);
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
		
	}
}
