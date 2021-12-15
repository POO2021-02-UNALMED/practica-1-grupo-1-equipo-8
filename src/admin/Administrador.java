package admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import gestorAplicacion.*;
import gestorAplicacion.personal.Dependiente;
import gestorAplicacion.personal.Tecnico;

import java.lang.Math;

import gestorAplicacion.tienda.Cliente;
import gestorAplicacion.tienda.Componente;
import gestorAplicacion.tienda.PrecioComponente;
import gestorAplicacion.tienda.Producto;
import gestorAplicacion.tienda.Servicio;

public class Administrador {
	static Scanner sc = new Scanner(System.in);

	static int readInt() {
		return sc.nextInt();

	}

	static String readString() {
		return sc.nextLine();

	}

	static double readDouble() {
		return sc.nextDouble();

	}

	public static void main(String[] args) {
		int opcion;
		Cliente cliente;
		do {

			System.out.println("�Buenos d�as Administrador\n");
			System.out.println("�Qu� desea hacer?");
			System.out.println(" 1. Diagnosticar un nuevo producto");
			System.out.println(" 2. Mandar a reparar un producto");
			System.out.println(" 3. Finalizar un servicio");
			System.out.println(" 4. Cobrar un servicio");
			System.out.println(" 5. Ver liquidaci�n");
			
			System.out.println(" Opciones");
			System.out.println(" 6. Guardar y cerrar");
			System.out.println(" 7. Generar cliente");
			System.out.println(" 8. Mostrar clientes");
			System.out.println(" 9. Mostrar servicios");

			System.out.println("Elija una opcion: ");
			opcion = (int) readInt();

			switch (opcion) {

			case 1:
				diagnosticar();
				break;
			case 2:
				reparar();
				break;
			case 3:
				finalizarServicio();
				break;
			case 4:
				cobrarServicio();
				break;
			case 5:
				liquidacion();
				break;
			case 7:
				 cliente = generarCliente();
				 System.out.println("Se genero el cliente id:" + 
				 (Cliente.getClientes().size()-1) + cliente.toString());
				break;
			case 8:
				for(int i= 0; i < Cliente.getClientes().size()-1; i++) {
					cliente = Cliente.getClientes().get(i);
					System.out.println("Cliente id:" + i + cliente.toString());
				}
				break;
			}
		} while (opcion != 6);

	}

	static void diagnosticar() {
		List<Componente> lista = new ArrayList<Componente>();
		System.out.println("Nombre Cliente: ");
		String nombre = readString();

		System.out.println("C�dula: ");
		String cedula = readString();

		System.out.println("�Cu�ntos productos reparar�? ");
		int cantProductos = readInt();

		List<Producto> listaProductos = new ArrayList<Producto>();
		int i;
		for (i = 0; i < cantProductos; i++) {
			System.out.println("Ingrese el nombre del producto " + (i + 1) + ": ");

			String nombreProducto = readString();
			// hacer el enum y un m�todo que entregue un producto dado su nombre
			Producto producto = newconseguirProducto(nombreProducto);

			listaProductos.add(producto);

		}

		// falta c�mo elegir un dependiente aleatorio

		double dinero = 450000 + 1000000 * Math.random();

		Cliente cliente = new Cliente(nombre, cedula, listaProductos, dependiente, dinero);

		for (i = 0; i < cantProductos; i++) {
			cliente.solicitarReparacion(producto);
			Servicio servicio = dependiente.getServicios().get(0);
			Tecnico.tecnicos.get(0).reparar(servicio);

		}

	}
	
	public static Cliente generarCliente() {
		String[] nombres = {
				"Esteban",
				"Emilio", 
				"Felipe", 
				"Erik", 
				"Alexander", 
				"Jaime", 
				"Alejandro", 
				"Emiliana", 
				"Dua lipa"
				};
		
		String[] nombreProductos = {
				"Laptop Legion 5",
				"Hp zbook 1",
				"Hp Omen 15",
				"Asus TUF Gaming",
				"HP XPS",
				"Macbook pro",
				"Lenovo Thinkpad",
				"Hp pavilion",
				"Gigabyte",
				"MSI Strike"
		};
		
		Componente[] componentes = { 
				new Componente("Memoria 4g Kinsgton", true, PrecioComponente.RAM_4GB.getPrecio()),
				new Componente("Disco duro SSD 256gb", true, PrecioComponente.DISCO_DURO_SSD_256GB.getPrecio()),
				new Componente("Bateria laptop lenovo supercharger", true, PrecioComponente.BATERIA_LAPTOP_SUPERCHARGER.getPrecio()),
				new Componente("Procesador AMD", true, PrecioComponente.PROCESADOR_AMD.getPrecio()),
				new Componente("Display 15 inch", true, PrecioComponente.DISPLAY_LAPTOP_15In.getPrecio()),
				new Componente("Memoria 8g Kinsgton", false, PrecioComponente.RAM_8GB.getPrecio()),
				new Componente("Disco duro HDD 512gb", false, PrecioComponente.DISCO_DURO_HDD_512GB.getPrecio()),
				new Componente("Bateria laptop lenovo", false, PrecioComponente.BATERIA_LAPTOP.getPrecio()),
				new Componente("Procesador Intel", false, PrecioComponente.PROCESADOR_INTEL.getPrecio()),
				new Componente("Display 17 inch", false, PrecioComponente.DISPLAY_LAPTOP_17In.getPrecio()),
		};
		
		Random rand = new Random();
        Dependiente dependiente = Dependiente.getDependientes().get(rand.nextInt(Dependiente.getDependientes().size()));
        List<Componente> productoComponentes = new ArrayList<Componente>();
        productoComponentes.add(componentes[rand.nextInt(5)]);
        productoComponentes.add(componentes[rand.nextInt(5)+5]);
        
        Producto producto = new Producto(
        		nombreProductos[rand.nextInt(nombreProductos.length)], 
        		productoComponentes);
        
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(producto);
		double cartera = 450000 + 1000000 * Math.random();

        Cliente cliente = new Cliente(
        		nombres[rand.nextInt(nombres.length)], 
        		""+rand.nextInt(9999999), 
        		productos,
        		dependiente,
        		cartera
        		);
        Cliente.getClientes().add(cliente);
        return cliente;
	}
}
