package gestorAplicacion.tienda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;
/**
 * 
 * @author Felipe Miranda
 * @summary Servicio deberia contener toda la informacion que relaciona a un cliente y su producto a reparar 
 * con los empleados (el dependiente que le atendio y el tecnico encargado de la reparacion) del sistema. 
 *
 */
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private int identificador;

	private static List<Servicio> servicios;
	private Tecnico tecnico;
	private boolean pagado;
	private Producto producto;
	private Date fecha;
	private Cliente cliente;
	private Dependiente dependiente;
	private double costo;
	private String diagnostico;
	private boolean reparado;
	
	static {
		servicios = new ArrayList<Servicio>();
	}
		

	public Servicio(Tecnico tecnico, Producto producto, Cliente cliente,
			Dependiente dependiente) {
		this.tecnico = tecnico;
		this.producto = producto;
		this.setFecha(new Date());
		this.cliente = cliente;
		this.dependiente = dependiente;
		this.reparado = false;
		if (servicios.isEmpty())
			identificador = 0;
		else 
			identificador = servicios.size();
		
		servicios.add(this);
	}


	public void setPagado(boolean pagado){
		this.pagado = pagado;
	}
	
	
	public Producto getProducto() {
		return producto;
	}


	public Dependiente getDependiente() {
		return dependiente;
	}
	/**
	 * 
	 * @summary costo seria la suma de los diferentes precios de cada componente que se arregle. 
	 * Si se va a agregar una pieza a la reparacion del producto, se debe sumar aca su total. 
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static List<Servicio> getServicios() {
		return servicios;
	}

	public static void setServicios(List<Servicio> servicios) {
		Servicio.servicios = servicios;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isReparado() {
		return reparado;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}
	
	public String toString() {
		return "\nIdentificador del servicio: " + this.identificador
				+ "\nCliente: " + this.cliente
				+ "\nProducto asociado: " + this.producto
				+ "\nReparado: " + this.reparado
				+ "\nPagado: " + this.pagado + "\n";
	}
	
	
	
}

