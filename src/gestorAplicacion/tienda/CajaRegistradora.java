package gestorAplicacion.tienda;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Erik Gonzalez
 * @summary En la caja registrado se lleva la contabilidad de los servicios, con el total de ingresos y
 * los servicios prestados
*/
public class CajaRegistradora {
	private double totalIngresos;
	private List<Servicio> servicios;
	
	public CajaRegistradora() {
		servicios = new ArrayList<Servicio>();
	}
	
	/**
	 * Registra la venta cuando finaliza el servico
	 * @param precio
	 * @param servicio
	 */
	public void registrarVenta(double precio, Servicio servicio) {
		servicios.add(servicio);
		this.totalIngresos += precio;
	}
	
	public double getTotalIngresos() {
		return this.totalIngresos;
	}
}
