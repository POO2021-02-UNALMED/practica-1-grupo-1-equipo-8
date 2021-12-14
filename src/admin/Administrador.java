package admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import gestorAplicacion.*;
import gestorAplicacion.personal.Tecnico;

import java.lang.Math;

import gestorAplicacion.tienda.Cliente;
import gestorAplicacion.tienda.Componente;
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

	static long readLong() {
		return sc.nextLong();

	}

	public static void main(String[] args) {
		int opcion;

		do {

			System.out.println("¡Buenos días Administrador\n");
			System.out.println("¿Qué desea hacer?");
			System.out.println(" 1. Diagnosticar un nuevo producto");
			System.out.println(" 2. Mandar a reparar un producto");
			System.out.println(" 3. Finalizar un servicio");
			System.out.println(" 4. Cobrar un servicio");
			System.out.println(" 5. Ver liquidación");
			System.out.println(" 6. Guardar y cerrar");

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
			case 6:
				break;

			}
		} while (opcion != 6);

	}

	static void diagnosticar() {
		List<Componente> lista = new ArrayList<Componente>();
		System.out.println("Nombre Cliente: ");
		String nombre = readString();

		System.out.println("Cédula: ");
		String cedula = readString();

		System.out.println("¿Cuántos productos reparará? ");
		int cantProductos = readInt();

		List<Producto> listaProductos = new ArrayList<Producto>();
		int i;
		for (i = 0; i < 2; i++) {
			System.out.println("Ingrese el nombre del producto " + (i + 1) + ": ");

			String nombreProducto = readString();
			// hacer el enum y un método que entregue un producto dado su nombre
			Producto producto = newconseguirProducto(nombreProducto);

			listaProductos.add(producto);

		}

		// falta cómo elegir un dependiente aleatorio

		double dinero = 450000 + 1000000 * Math.random();

		Cliente cliente = new Cliente(nombre, cedula, listaProductos, dependiente, dinero);

		for (i = 0; i < 2; i++) {
			cliente.solicitarReparacion(producto);
			Servicio servicio = dependiente.getServicios().get(0);
			Tecnico.tecnicos.get(0).reparar(servicio);

		}

	}

}
