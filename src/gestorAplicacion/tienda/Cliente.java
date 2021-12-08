package gestorAplicacion.tienda;

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
	private Dependiente dependiente;
	
	public Cliente(String nombre, String cedula, List<Producto> productos, Dependiente dependiente) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.productos = productos;
		this.dependiente = dependiente;
	}
	
	public void solicitarReparacion(Producto producto) {
		this.dependiente.atenderCliente(this, producto);
	}
	
	/**
	 * El cliente solo puede pagar el servicio cuando esta finalizado, al finalizar el metodo
	 * retorna un boolean que confirma si pago o no el servicio.
	 * @param servicio
	 * @return boolean
	 */
	public boolean pagarServicio(Servicio servicio) {
		if(!servicio.isPagado()) {
			servicio.pagar();
		}
		return servicio.isPagado();
	}
	
	public void recibirProducto() {
	}
}
