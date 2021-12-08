package gestorAplicacion.tienda;
/**
 * 
 * @author Felipe Miranda
 * @summary Componente son las posibles partes que requiere un producto para ser reparado. Se almacenan en bodega. 
 * tienen averiado (si el producto est� bueno o no), precio (de ac� se calcular�n las ganancias), y nombre. 
 */
public class Componente {
	private String nombre;
	private boolean averiado;
	private double precio;
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
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
