package gestorAplicacion.tienda;
import java.util.Date;
import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;
/**
 * 
 * @author Felipe Miranda
 * {@summary} Servicio deberá contener toda la información que relaciona a un cliente y su producto a reparar 
 * con los empleados (el dependiente que le atendió y el técnico encargado de la reparación) del sistema. 
 *
 */
public class Servicio {
	Tecnico tecnico;
	boolean pagado;
	Producto producto;
	Date fecha;
	Cliente cliente;
	Dependiente dependiente;
	double costo;
	String diagnostico;
	
	public Servicio() {}

	public Servicio(Tecnico tecnico, boolean pagado, Producto producto, Cliente cliente,
			Dependiente dependiente, double costo, String diagnostico) {
		super();
		this.tecnico = tecnico;
		this.pagado = pagado;
		this.producto = producto;
		Date fecha = new Date();
		this.cliente = cliente;
		this.dependiente = dependiente;
		this.costo = costo;
		this.diagnostico = diagnostico;
	}


	public void pagar(){}


	public Producto getProducto() {
		return producto;
	}


	public Dependiente getDependiente() {
		return dependiente;
	}
	
	public void anadirCosto(double costo) {
		this.costo+=costo;
	}
	
	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}	
	
}

