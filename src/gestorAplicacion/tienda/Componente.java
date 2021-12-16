package gestorAplicacion.tienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Felipe Miranda
 * @summary Componente son las posibles partes que requiere un producto para ser reparado. Se almacenan en bodega. 
 * tienen averiado (si el producto est� bueno o no), precio (de ac� se calcular�n las ganancias), y nombre. 
 */
public class Componente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean averiado;
	private double precio;
	
	public static List<Componente> componentes;
	
	static {
		componentes = new ArrayList<Componente>();
	}
	
	public Componente(String nombre, boolean averiado) {
		this.nombre = nombre;
		this.averiado = averiado;
	}

	public Componente(String nombre, boolean averiado, double precio) {
		this(nombre, averiado);
		this.precio = precio;
		componentes.add(this);
	}

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
	
	public String toString() {
		return nombre;
	}
	
	
}
