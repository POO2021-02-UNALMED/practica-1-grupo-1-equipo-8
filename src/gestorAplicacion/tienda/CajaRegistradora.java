package gestorAplicacion.tienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.personal.*;
/**
 * 
 * @author Erik Gonzalez
 * @summary En la caja registrado se lleva la contabilidad de los servicios, con el total de ingresos y
 * los servicios prestados
*/
public class CajaRegistradora implements Serializable {
	private static final long serialVersionUID = 1L;
	private double totalIngresos;
	private List<Servicio> servicios;
	
	public static List<CajaRegistradora> cajasRegistradoras;
	
	static {
		cajasRegistradoras = new ArrayList<CajaRegistradora>();
	}
	
	public CajaRegistradora() {
		servicios = new ArrayList<Servicio>();
		cajasRegistradoras.add(this);
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

	public void setTotalIngresos(double totalIngresos) {
		this.totalIngresos = totalIngresos;
	}
	
	public double descontar(double porcentaje) {
		double descuento = this.totalIngresos*porcentaje;
		this.totalIngresos-= descuento;
		return descuento;
	}
}
