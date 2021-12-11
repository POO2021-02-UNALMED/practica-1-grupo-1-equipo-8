package gestorAplicacion.tienda;

import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.personal.Dependiente;

/**
 * 
 * @author Erik Gonzalez
 * @summary El cliente tiene tres funcionalidades. solicitar una reparacion, pagar es servicio que se
 * se presto y recibir su producto.
 * El cliente muchas veces puede pa
*/
public class Cliente {
	private String nombre;
	private String cedula;
	private List<Producto> productos;
	private List<String> recibos;
	private Dependiente dependiente;
	
	public Cliente(String nombre, String cedula, List<Producto> productos, Dependiente dependiente) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.productos = productos;
		this.dependiente = dependiente;
		this.recibos = new ArrayList<String>();
	}
	
	/**
	 * El cliente solicita la reparacion de un producto 
	 * @param producto
	 */
	public void solicitarReparacion(Producto producto) {
		this.dependiente.atenderCliente(this, producto);
		productos.remove(producto);
	}
	
	/**
	 * El cliente solo puede pagar el servicio cuando esta finalizado, al finalizar el metodo
	 * retorna un boolean que confirma si pago o no el servicio.
	 * @param servicio
	 * @return boolean
	 */
	public void pagarServicio(Servicio servicio) {
		if(!servicio.isPagado()) {
			servicio.pagar();
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
	
	
}
