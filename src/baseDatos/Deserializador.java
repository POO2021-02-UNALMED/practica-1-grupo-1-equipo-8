package baseDatos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import gestorAplicacion.tienda.Bodega;
import gestorAplicacion.tienda.Componente;

public class Deserializador {

		private static File rutaTemp = new File("sr\\baseDatos\\Temp");

		public static void deserializar(Componente componente) {
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
					
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				}
					//else if () {}
			}
		}
	}
}
