package gestorAplicacion.tienda;

import java.util.List;

import gestorAplicacion.personal.Dependiente;

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
		
	}
	
	public void pagarServicio(Servicio servicio) {
		
	}
	
	public void recibirProducto() {
		
	}
}
