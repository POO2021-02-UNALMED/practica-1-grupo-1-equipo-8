package baseDatos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


import gestorAplicacion.tienda.Producto;

public class Deserializador {

		private static File rutaTemp = new File("sr\\baseDatos\\Temp");

		public static void deserializar(Producto producto) {
			File[] docs = rutaTemp.listFiles();
			FileInputStream fis;
			ObjectInputStream ois;
			

			for (File file : docs) {
				if (file.getAbsolutePath().contains("productos")) {
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						producto.setProducto((Producto) ois.readObject());
						

				} catch (FileNotFoundException e) {
					e.printStackTrace();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				}
					//else if () {}
			}
		}
	}
}
