package gestorAplicacion.tienda;
import java.util.Date;
import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;
/**
 * 
 * @author Felipe Miranda
 * {@summary} Servicio deber� contener toda la informaci�n que relaciona a un cliente y su producto a reparar 
 * con los empleados (el dependiente que le atendi� y el t�cnico encargado de la reparaci�n) del sistema. 
 *
 */
public class Servicio {
	
	private int identificador;
	private static int proximoIdentificador;
	Tecnico tecnico;
	boolean pagado;
	Producto producto;
	Date fecha;
	Cliente cliente;
	Dependiente dependiente;
	double costo;
	String diagnostico;
	
	public Servicio() {
		this.identificador = proximoIdentificador;
		proximoIdentificador += 1;
	}

	public Servicio(Tecnico tecnico, Producto producto, Cliente cliente,
			Dependiente dependiente) {
		this();
		this.tecnico = tecnico;
		this.producto = producto;
		this.fecha = new Date();
		this.cliente = cliente;
		this.dependiente = dependiente;
	}


	public void pagar(){
		
		
	}
	
	
	public Producto getProducto() {
		return producto;
	}


	public Dependiente getDependiente() {
		return dependiente;
	}
	/**
	 * 
	 * @param costo ser� la suma de los diferentes precios de cada componente que se arregle. 
	 * Si se va a agregar una pieza a la reparaci�n del producto, se debe sumar ac� su total. 
	 */
	public void anadirCosto(double precio) {
		this.costo+=precio;
	}
	
	public double getCosto() {
		return costo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}	
	
	public boolean isPagado() {
		return pagado;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getIdentificador() {
		return identificador;
	}	
}

