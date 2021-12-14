package gestorAplicacion.personal;
import gestorAplicacion.tienda.CajaRegistradora;
import gestorAplicacion.tienda.Servicio;

public interface Personal {
	public abstract void quitarServicio(Servicio servicio);
	public abstract void asignarServicio(Servicio servicio);
	public abstract void cobrarSalario(CajaRegistradora caja);
	public abstract String agradecer();
}
