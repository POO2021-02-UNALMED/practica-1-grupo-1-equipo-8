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
import gestorAplicacion.personal.Tecnico;
import gestorAplicacion.tienda.Bodega;
import gestorAplicacion.tienda.CajaRegistradora;
import gestorAplicacion.tienda.Cliente;
import gestorAplicacion.tienda.Componente;
import gestorAplicacion.tienda.Producto;
import gestorAplicacion.tienda.Servicio;

public class Deserializador {
		public static <E> void deserializador(List<E> list, String className) {
			FileInputStream fileIn;
			try {
				String path = System.getProperty("user.dir") + "/src/baseDatos/Temp/"+className+".txt";
				System.out.println(path);
			    File archivo = new File(path);
			    archivo.createNewFile();
			    
				fileIn = new FileInputStream(path);
				
				ObjectInputStream in = new ObjectInputStream(fileIn);
				
				ArrayList<E> listado;
				
				listado = (ArrayList<E>) in.readObject();
				
				//Recorro el ArrayList
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
		
		public static void deserializarTodo() {
			Deserializador.deserializador(Dependiente.getDependientes(), "Dependientes");
			Deserializador.deserializador(Tecnico.tecnicos, "Tecnicos");
			Deserializador.deserializador(CajaRegistradora.cajasRegistradoras, "CajasRegistradoras");
			Deserializador.deserializador(Cliente.getClientes(), "Clientes");
			Deserializador.deserializador(Componente.componentes, "Componentes");
			Deserializador.deserializador(Producto.productos, "Productos");
			Deserializador.deserializador(Servicio.getServicios(), "Servicios");
			Deserializador.deserializador(Bodega.getComponentes(), "Bodega");
		}
}
