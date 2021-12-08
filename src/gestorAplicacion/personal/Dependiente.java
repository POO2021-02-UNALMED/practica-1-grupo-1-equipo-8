package gestorAplicacion.personal;

import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.tienda.*;
/**
 * 
 * @author Esteban Garc�a
 *
 */
public class Dependiente extends Empleado {
	
	private CajaRegistradora cajaRegistradora;
	
	public Dependiente(String nombre, int cedula, CajaRegistradora caja) {
		super(nombre, cedula);
		this.cajaRegistradora = caja;
	}
	
	public void atenderCliente(Cliente cliente, Producto producto) {
		
	}
	
	public void registrarPago() {
		
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El m�todo quitarServicio recibe como par�metro un servicio y lo remueve de la lista de servicios del t�cnico en cuesti�n.
	 * 
	 */
	public void quitarServicio(Servicio servicio) {
		this.getServicios().remove(servicio);
		
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El m�todo asignarServicio recibe como par�metro un servicio y lo agrega a la lista de servicios del t�cnico en cuesti�n.
	 * 
	 */
	public void asignarServicio(Servicio servicio) {
		this.getServicios().add(servicio);
	}
	
	/**
	 * 
	 * @param tecnico
	 * @param producto
	 * @summary generar servicio crea un servicio para revisar un producto que se le asigna a la lista de servicios 
	 * dependiente que lo cre� y al t�cnico que va a realizarlo.
	 * 
	 */
	public void generarServicio(Tecnico tecnico, Producto producto) {
		Servicio servicio = new Servicio(tecnico, false, producto, producto.getDueno(), this, 0, ""); //////////Recibe qu� parametros?/////////
		this.getServicios().add(servicio);
		tecnico.asignarServicio(servicio);
		
		
	}
	
	public void finalizarServicio(Servicio servicio) {
		this.quitarServicio(servicio);
		System.out.println("Servicio finalizado");
		
	}
	
	private void notificarCliente(Cliente cliente) {
		System.out.println("El dependiente llama al cliente a notificarle el estado del servicio pedido para que recoja el producto");
	}
	
	private void entregarProducto(Producto producto) {
		
	}
}
