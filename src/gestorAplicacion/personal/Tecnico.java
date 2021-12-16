package gestorAplicacion.personal;
import java.io.Serializable;
import java.util.*;
import gestorAplicacion.tienda.*;

/**
 * 
 * @author Emilio Porras
 * @summary Esta clase busca representar el comportamiento de un empleado tipo tecnico
 * Estructuras relevantes: servicios es una lista de servicios que se va modificando a medida que el tecnico toma o finaliza servicios
 *
*/

public class Tecnico extends Empleado implements Serializable {
	private static final long serialVersionUID = 1L;
	public static List<Tecnico> tecnicos;
	static {
		tecnicos = new ArrayList<Tecnico>();
		new Tecnico("Emilio", 987654);
	}
	
	public Tecnico(String nombre, int cedula) {
		super(nombre, cedula);
		tecnicos.add(this);
	}
	
	public Tecnico(String nombre, int cedula, List<Servicio> servicios) {
		this(nombre, cedula);
		this.servicios = servicios;
		tecnicos.add(this);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El metodo verificarProblemas es un metodo auxiliar de la clase, el cual recibe un servicio y devuelve una lista con los componentes
	 * averiados en el producto correspondiente a ese servicio
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
	 * @summary El metodo buscarComponente es un metodo auxiliar de la clase, el cual recibe un componente y devuelve booleano dependiendo de si un componente
	 * con el mismo nombre se encuentra en la Bodega o no.
	 * 
	 */
	private Componente buscarComponente(Componente componente) {
		return Bodega.sacarComponente(componente.getNombre());
	}
	/**
	 * 
	 * @param servicio
	 * @summary El metodo diagnosticar recibe como paremetro un servicio y modifica en este su atributo diagostico, brindando informacion 
	 * sobre los problemas del producto correspondiente.
	 *  
	 */
	public void diagnosticar(Servicio servicio) {
		servicio.setDiagnostico("Se encontraron problemas en los siguientes componentes del producto: "+ verificarProblemas(servicio));
	}
	/**
	 * 
	 * @param servicio
	 * @summary El metodo reparar recibe como parametro un servicio. Luego, revisa si los componentes aveados estan disponibles en la bodega y, a 
	 * aquellos que estan disponibles, los remueve de la lista de Bodega y los reemplaza en la lista de componentes del producto. Tambien, va sumando
	 * el precio de los componentes utilizados en el atributo costo de servicio.
	 * 
	 */
	public void reparar(Servicio servicio) {
		Producto producto = servicio.getProducto();
		List<Componente> averiados = verificarProblemas(servicio);
		for (Componente componente: averiados) {
			Componente remplazo = buscarComponente(componente);
			if (remplazo != null) {
				Componente componenteBodega = Bodega.sacarComponente(remplazo);
				producto.quitarComponente(componente);
				producto.agregarComponente(componenteBodega);
				servicio.setCosto(servicio.getCosto()+componenteBodega.getPrecio());
			}
		}
		servicio.setReparado(true);
		quitarServicio(servicio);
	}
	/**
	 * 
	 * @param servicio
	 * @summary El metodo asignarServicio recibe como parametro un servicio y lo agrega a la lista de servicios del tecnico en cuestion.
	 * 
	 */
	public void asignarServicio(Servicio servicio) {
		this.getServicios().add(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El metodo quitarServicio recibe como parametro un servicio y lo remueve de la lista de servicios del tecnico en cuestion.
	 * 
	 */
	public void quitarServicio(Servicio servicio) {
		this.getServicios().remove(servicio);
	}
	
	public void cobrarSalario(CajaRegistradora caja) {
		double porcentaje = 0.02;
		this.cartera+= caja.descontar(porcentaje);
	}
	
	public String toString() {
		return "Tecnico: " + this.getNombre();
	}
}
