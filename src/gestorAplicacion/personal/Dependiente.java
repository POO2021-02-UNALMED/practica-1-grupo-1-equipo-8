package gestorAplicacion.personal;

import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.tienda.*;
/**
 * 
 * @author Esteban Garcia
 * @summary Busca representar el comportamiento de un empleado dependiente, quien esta a cargo de atender a los clientes y asignar servicios.
 * Es mediante el cual se efectuan los pagos y pasan los productos solicitados para reparar y se devuelven a sus clientes.  
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
	
	public void registrarPago(Servicio servicio) {
		cajaRegistradora.registrarVenta(servicio.getCosto(), servicio);
		quitarServicio(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El metodo quitarServicio recibe como par�metro un servicio y lo remueve de la lista de servicios del t�cnico en cuesti�n.
	 * 
	 */
	public void quitarServicio(Servicio servicio) {
		this.getServicios().remove(servicio);
		
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary El metodo asignarServicio recibe como par�metro un servicio y lo agrega a la lista de servicios del t�cnico en cuesti�n.
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
		Servicio servicio = new Servicio(tecnico, producto, producto.getDueno(), this, ""); //////////Recibe qu� parametros?/////////
		this.getServicios().add(servicio);
		tecnico.asignarServicio(servicio);
		
		
	}
	/**
	 * 
	 * @param servicio
	 * @summary Se hace entrega del producto al due�o (cliente) para que lo revise y recibir luego el pago.
	 */
	public void finalizarServicio(Servicio servicio) {
		
		notificarCliente(servicio.getProducto().getDueno());
		this.entregarProducto(servicio.getProducto());
		System.out.println("Servicio finalizado");
		
	}
	
	/**
	 * 
	 * @param cliente
	 */
	private void notificarCliente(Cliente cliente) {
		
		System.out.println("El dependiente llama al cliente " + cliente.getNombre() + " con cedula " + cliente.getCedula() + 
				" a notificarle el estado del servicio pedido para que recoja el producto");
	}
	
	/**
	 * 
	 * @param producto
	 * @summary m�todo de entrega del producto al cliente due�o.
	 */
	private void entregarProducto(Producto producto) {
		
		producto.getDueno().getProductos().add(producto);
		System.out.println("El producto ha sido devuelvo al dueno");
	}
}
