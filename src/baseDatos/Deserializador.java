package baseDatos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.tienda.Bodega;
import gestorAplicacion.tienda.Componente;
import gestorAplicacion.tienda.CajaRegistradora;
import gestorAplicacion.tienda.Cliente;

public class Deserializador {

		private static File rutaTemp = new File("src\\baseDatos\\Temp");

		public static void deserializarBodega(Bodega bodega) {
			File[] docs = rutaTemp.listFiles();
			FileInputStream fis;
			ObjectInputStream ois;
			

			for (File file : docs) {
				if (file.getAbsolutePath().contains("componentes")) {
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						Bodega.setComponentes((List<Componente>) ois.readObject());
						

				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				}
				}
			}
		}
		
	

		public static void deserializarCajaRegistradora(CajaRegistradora caja) {
			File[] docs = rutaTemp.listFiles();
			FileInputStream fis;
			ObjectInputStream ois;
			

			for (File file : docs) {
				if (file.getAbsolutePath().contains("componentes")) {
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						caja.setTotalIngresos((int) ois.readObject());
						

				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				}
				}
			}
		}
		public static void deserializarDependiente(Dependiente dependiente) {
			File[] docs = rutaTemp.listFiles();
			FileInputStream fis;
			ObjectInputStream ois;
			

			for (File file : docs) {
				if (file.getAbsolutePath().contains("dependientes")) {
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						dependiente.setDependientes((List<Dependiente>) ois.readObject());
						

				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				}
				}
			}
		}
		
		public static void deserializarCliente(Cliente cliente) {
			File[] docs = rutaTemp.listFiles();
			FileInputStream fis;
			ObjectInputStream ois;
			

			for (File file : docs) {
				if (file.getAbsolutePath().contains("clientes")) {
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						Cliente.setClientes((List<Cliente>) ois.readObject());
						
						

				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				}
				}
			}
		}
		public static void deserealizartodo () {
			deserializarDependiente();
			deserializar
		}
}
