package gestorAplicacion.tienda;

import java.util.ArrayList;
import java.util.List;

public class CajaRegistradora {
	private double totalIngresos;
	private List<Servicio> servicios;
	
	public CajaRegistradora() {
		servicios = new ArrayList<Servicio>();
	}
	
	public void registrarVenta(double precio, Servicio servicio) {
		servicios.add(servicio);
		this.totalIngresos += precio;
	}
	
	public double getTotalIngresos() {
		return this.totalIngresos;
	}
}
