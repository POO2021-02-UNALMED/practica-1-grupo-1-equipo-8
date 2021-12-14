package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.tienda.Producto;
import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.tienda.Bodega;
import gestorAplicacion.tienda.Componente;
import gestorAplicacion.tienda.CajaRegistradora;
import gestorAplicacion.tienda.Cliente;

public class Serializador {

	private static File rutaTemp = new File("sr\\baseDatos\\Temp");

	public static void serializarBodega(Bodega bodega) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File file : docs) {
			try {
				pw = new PrintWriter(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		for (File file : docs) {
			if (file.getAbsolutePath().contains("componentes")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Bodega.getComponentes());

				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		
		}
	}

	public static void serializarCajaRegistradora(CajaRegistradora caja) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File file : docs) {
			try {
				pw = new PrintWriter(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		for (File file : docs) {
			if (file.getAbsolutePath().contains("dinero")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(caja);

				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
	public static void serializarDependiente(Dependiente dependiente) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File file : docs) {
			try {
				pw = new PrintWriter(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		for (File file : docs) {
			if (file.getAbsolutePath().contains("dependientes")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(dependiente.getDependientes());

				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
	public static void serializarCliente(Cliente cliente) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		for (File file : docs) {
			try {
				pw = new PrintWriter(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		for (File file : docs) {
			if (file.getAbsolutePath().contains("clientes")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(cliente.getClientes());

				} catch (FileNotFoundException e) {
					e.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
}
