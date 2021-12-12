package gestorAplicacion.personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	
	/**
	 * 
	 * @param cliente
	 * @param producto
	 * @summary Este metodo elige a alguno de los tecnicos disponibles para asignarle un nuevo servicio con
	 * el producto entregado por el cliente.
	 */
	public void atenderCliente(Cliente cliente, Producto producto) {
		Random rand = new Random();
        Tecnico tecnico = Tecnico.tecnicos.get(rand.nextInt(Tecnico.tecnicos.size()));
		producto.setDueno(cliente);
        generarServicio(tecnico, producto);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary Registra el pago en la caja registradora con el costodel servicio que decidio el tecnico y luego quita el servicio.
	 * 
	 */
	public void registrarPago(Servicio servicio) {
		cajaRegistradora.registrarVenta(servicio.getCosto(), servicio);
		quitarServicio(servicio);
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
	 * @param tecnico
	 * @param producto
	 * @summary generar servicio crea un servicio para revisar un producto que se le asigna a la lista de servicios 
	 * dependiente que lo creo y al tecnico que va a realizarlo.
	 * 
	 */
	public void generarServicio(Tecnico tecnico, Producto producto) {
		Servicio servicio = new Servicio(tecnico, producto, producto.getDueno(), this);
		tecnico.asignarServicio(servicio);
		asignarServicio(servicio);
	}
	
	/**
	 * 
	 * @param servicio
	 * @summary Se hace entrega del producto al dueno (cliente) para que lo revise y recibir luego el pago.
	 */
	public void finalizarServicio(Servicio servicio) {
		notificarCliente(servicio);
		entregarProducto(servicio.getProducto());		
	}
	
	/**
	 * 
	 * @param cliente
	 */
	private void notificarCliente(Servicio servicio) {
		Cliente cliente = servicio.getProducto().getDueno();
		String recibo = "Factura #" + servicio.getIdentificador() + "\n" + 
						"Cliente: " +cliente.getNombre() + " con cedula " + cliente.getCedula() + "\n" + 
						"Recibir el producto: " + servicio.getProducto().toString();
		cliente.recibirRecibo(recibo);
	}
	
	/**
	 * 
	 * @param producto
	 * @summary metodo de entrega del producto al cliente dueno.
	 * 
	 */
	private void entregarProducto(Producto producto) {
		
		producto.getDueno().recibirProducto(producto);;
		System.out.println("El producto ha sido devuelvo al dueno");
	}
}
