package baseDatos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Empleado;
import gestorAplicacion.personal.Tecnico;
import gestorAplicacion.tienda.Bodega;
import gestorAplicacion.tienda.CajaRegistradora;
import gestorAplicacion.tienda.Cliente;
import gestorAplicacion.tienda.Componente;
import gestorAplicacion.tienda.Producto;
import gestorAplicacion.tienda.Servicio;

/**
 * Clase para deserializar los objetos que se crearon en ejecucion
 * @author Erik Gonzalez
 * @author Felipe Miranda
 */
public class Deserializador {
	/**
	 * Utilizamos clases genericas para permitir reutilizar la funcion para todas
	 * las clases del proyecto
	 * 
	 * @param <E>       el generico se usa para poder agredar las clases que se
	 *                  crearon
	 * @param lista     Una lista de objetos
	 * @param className El nombre de la clase que queremos usar como nombre del
	 *                  archivo
	 */
	public static <E> void deserializador(List<E> list, String className) {
		FileInputStream fileIn;
		try {
			String path = System.getProperty("user.dir") + "/src/baseDatos/temp/" + className + ".txt";
			System.out.println(path);
			File archivo = new File(path);
			archivo.createNewFile(); // Crea un nuevo archivo si no existe

			fileIn = new FileInputStream(path);

			// Si el archivo esta vacio se lanza un throw EOFException y se muestra como un
			// mensaje de vacio
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Lee el listado de elementos
			ArrayList<E> listado = (ArrayList<E>) in.readObject();

			// Recorro el ArrayList
			for (E el : listado) {
				list.add(el);
			}

			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("Esta vacio");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Funcion para deserializar toda la aplicacion Generic IT
	 */
	public static void deserializarTodo() {
		Deserializador.deserializador(Dependiente.getDependientes(), "Dependientes");
		Deserializador.deserializador(Tecnico.tecnicos, "Tecnicos");
		Deserializador.deserializador(CajaRegistradora.cajasRegistradoras, "CajasRegistradoras");
		Deserializador.deserializador(Cliente.getClientes(), "Clientes");
		Deserializador.deserializador(Componente.componentes, "Componentes");
		Deserializador.deserializador(Producto.productos, "Productos");
		Deserializador.deserializador(Servicio.getServicios(), "Servicios");
		Deserializador.deserializador(Bodega.getComponentes(), "Bodega");
		Deserializador.deserializador(Empleado.getEmpleados(), "Empleados");
	}
}
