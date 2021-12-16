package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
