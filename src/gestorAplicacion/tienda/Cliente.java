package gestorAplicacion.tienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import baseDatos.Deserializador;
import gestorAplicacion.personal.Dependiente;

/**
 * 
 * @author Erik Gonzalez
 * @summary El cliente tiene tres funcionalidades. solicitar una reparacion,
 *          pagar es servicio que se se presto y recibir su producto. El cliente
 *          muchas veces puede pa
 */
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String cedula;
	private List<Producto> productos;
	private List<String> recibos;
	private Dependiente dependiente;
	private double cartera;
	static List<Cliente> clientes;
	static {
		clientes = new ArrayList<Cliente>();
	}
	public Cliente() {}
	
	public Cliente(String nombre, String cedula, List<Producto> productos, Dependiente dependiente, double cartera) {
		this();
		this.nombre = nombre;
		this.cedula = cedula;
		this.productos = productos;
		this.dependiente = dependiente;
		this.cartera = cartera;
		this.recibos = new ArrayList<String>();
	}

	/**
	 * El cliente solicita la reparacion de un producto
	 * 
	 * @param producto
	 */
	public void solicitarReparacion(Producto producto) {
		this.dependiente.atenderCliente(this, producto);
		productos.remove(producto);
	}

	/**
	 * El cliente solo puede pagar el servicio cuando esta finalizado.
	 * 
	 * @param servicio
	 * 
	 */
	public void pagarServicio(Servicio servicio, double cobro) {
		if (!servicio.isPagado() && cartera >= cobro) {
			cartera -= cobro;
		}
	}

	public void recibirProducto(Producto producto) {
		this.productos.add(producto);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Dependiente getDependiente() {
		return dependiente;
	}

	public void setDependiente(Dependiente dependiente) {
		this.dependiente = dependiente;
	}

	public void recibirRecibo(String recibo) {
		this.recibos.add(recibo);
	}

	public List<String> getRecibos() {
		return this.recibos;
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(List<Cliente> clientes) {
		Cliente.clientes = clientes;
	}

	public double getCartera() {
		return cartera;
	}	
	
	public String toString() {
		return " Nombre: " + nombre + " CC: " + cedula + " Cartera: " + cartera;
	}
}
