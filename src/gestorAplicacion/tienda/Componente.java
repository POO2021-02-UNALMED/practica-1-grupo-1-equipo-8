package gestorAplicacion.tienda;
/**
 * 
 * @author Felipe Miranda
 * @summary Componente son las posibles partes que requiere un producto para ser reparado. Se almacenan en bodega. 
 * tienen averiado (si el producto está bueno o no), precio (de acá se calcularán las ganancias), y nombre. 
 */
public class Componente {
	private String nombre;
	private boolean averiado;
	private double precio;
	public String getNombre() {
		return nombre;
	}
	public boolean isAveriado() {
		return averiado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
