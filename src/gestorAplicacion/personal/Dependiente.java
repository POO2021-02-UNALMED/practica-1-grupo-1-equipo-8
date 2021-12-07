package gestorAplicacion.personal;

import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.tienda.*;
/**
 * 
 * @author Esteban García
 *
 */
public class Dependiente extends Empleado {
	
	private CajaRegistradora cajaRegistradora;
	
	public Dependiente(String nombre, int cedula, CajaRegistradora caja) {
		super(nombre, cedula);
		this.cajaRegistradora = caja;
	}
	
	public void atenderCliente(Cliente cliente) {
		
	}
	
	public void registrarPago() {
		
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El método quitarServicio recibe como parámetro un servicio y lo remueve de la lista de servicios del técnico en cuestión.
	 * 
	 */
	public void quitarServicio(Servicio servicio) {
		this.getServicios().remove(servicio);
		
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El método asignarServicio recibe como parámetro un servicio y lo agrega a la lista de servicios del técnico en cuestión.
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
	 * dependiente que lo creó y al técnico que va a realizarlo.
	 * 
	 */
	public void generarServicio(Tecnico tecnico, Producto producto) {
		Servicio servicio = new Servicio(); //////////Recibe qué parametros?/////////
		this.getServicios().add(servicio);
		tecnico.asignarServicio(servicio);
		
		
	}
	
	public void finalizarServicio(Servicio servicio) {
		this.quitarServicio(servicio);
		System.out.println("Servicio finalizado");
		
	}
	
	private void notificarCliente(Cliente cliente) {
		System.out.println("El dependiente llamó al cliente a notificarle el estado del servicio pedido para que recoja el producto");
	}
	
	private void entregarProducto(Producto producto) {
		
	}
}
