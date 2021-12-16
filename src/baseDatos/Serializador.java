package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;
import gestorAplicacion.tienda.Bodega;
import gestorAplicacion.tienda.CajaRegistradora;
import gestorAplicacion.tienda.Cliente;
import gestorAplicacion.tienda.Componente;
import gestorAplicacion.tienda.Producto;
import gestorAplicacion.tienda.Servicio;

public class Serializador {
	public static <E> void serializar(List<E> lista, String className) {
		FileOutputStream fileOut;

		try {
			String path = System.getProperty("user.dir") + "/src/baseDatos/Temp/"+className+".txt";
			fileOut = new FileOutputStream(path);
			
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			
			out.writeObject(lista);
			out.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void serializarTodo() {
		Serializador.serializar(Dependiente.getDependientes(), "Dependientes");
		Serializador.serializar(Tecnico.tecnicos, "Tecnicos");
		Serializador.serializar(CajaRegistradora.cajasRegistradoras, "CajasRegistradoras");
		Serializador.serializar(Cliente.getClientes(), "Clientes");
		Serializador.serializar(Componente.componentes, "Componentes");
		Serializador.serializar(Producto.productos, "Productos");
		Serializador.serializar(Servicio.getServicios(), "Servicios");
		Serializador.serializar(Bodega.getComponentes(), "Bodega");
	}
}
