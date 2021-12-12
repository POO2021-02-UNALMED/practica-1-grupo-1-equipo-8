package baseDatos;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.tienda.producto;

public class Serializador {

	public class Serializador {
		private static File rutaTemp = new File("sr\\baseDatos\\Temp");

		public static void serializar(Producto producto) {
			FileOutputStream fos;
			ObjectOutputStream oos;
			File[] docs = rutaTemp.listFiles();
			Printwriter pw;

			for (File file : docs) {
				try {
					pw = new PrintWriter(file);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
