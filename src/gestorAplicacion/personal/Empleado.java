package gestorAplicacion.personal;

import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.tienda.*;
/**
 * 
 * @author Esteban García
 * @summary Clase padre de Tecnico y Dependiente. Define los comportamientos en comun y en general de las clases que heredan de ella.
 * Punto importante: La lista servicios, la cual mantiene todos los servicios en los que un empleado esté trabajando/involucrado.
 *
 */
public abstract class Empleado implements Personal {

	private String nombre;
	private int cedula;
	protected List<Servicio> servicios;
	private double cartera;
	private static List<Empleado> empleados;
	
	public Empleado (String nombre, int cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
		servicios = new ArrayList<Servicio>();
		Empleado.empleados.add(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public List<Servicio> getServicios(){
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
}
