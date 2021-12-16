package uiMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.personal.*;
import gestorAplicacion.tienda.*;

import java.io.IOException;
import java.lang.Math;

public class Administrador {
	static Scanner sc = new Scanner(System.in);
	static Bodega bodega = new Bodega();

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
		cargar();
		inicializar();
		for (Empleado empleado : Empleado.getEmpleados()) {
			System.out.println(empleado.toString());
		}
		int opcion;
		Cliente cliente;
		do {
			System.out.println("Buenos dias Administrador\n");
			System.out.println("Que desea hacer?");
			System.out.println(" 1. Menu diagnosticar un producto");
			System.out.println(" 2. Reparar un producto");
			System.out.println(" 3. Finalizar un servicio");
			System.out.println(" 4. Cobrar un servicio");
			System.out.println(" 5. Liquidación del periodo");

			System.out.println(" Opciones alternativas");
			System.out.println(" 6. Mostrar clientes");
			System.out.println(" 7. Mostrar servicios");
			System.out.println(" 8. Guardar y cerrar");

			System.out.println("Elija una opcion: ");
			opcion = (int) readInt();

			switch (opcion) {

			case 1:
				menuDiagnosticar();
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
				liquidar();
				break;
			case 6:
				for (int i = 0; i < Cliente.getClientes().size(); i++) {
					cliente = Cliente.getClientes().get(i);
					System.out.println("Cliente id:" + i + cliente.toString());
				}
				break;
			case 7:
				System.out.println("Servicio activos:");
				for (int i = 0; i < Servicio.getServicios().size(); i++) {
					Servicio servicio = Servicio.getServicios().get(i);
					System.out.println("Servicio id:" + i + servicio.toString());
				}
				break;
				
			case 8:
				guardar();
				System.out.println("Vuelve pronto");
			}
			if (opcion != 8) {
				//guardar();
				System.out.println("\nPresione cualquier tecla para continuar");
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} while (opcion != 8);

	}

	static void diagnosticar() {
		try {
			System.out.println("Ingrese el id del servicio");
			int idServicio = readInt();
			Servicio servicio = Servicio.getServicios().get(idServicio);
			servicio.getTecnico().diagnosticar(servicio);
			System.out.println(servicio.getDiagnostico());
			System.out.println("Ya puede volver al menu principal para solicitar reparacion");
		} catch (Exception e) {
			System.out.println("El id del servicio no es correcto");
		}
	}

	static void reparar() {
		try {
			System.out.println("Escoja el servicio con su index para reparar el producto asociado: ");

			int index = readInt();
			try {
				Servicio servicio = Servicio.getServicios().get(index);

				if (!servicio.isReparado()) {
					if (servicio.getDiagnostico() != null) {
						servicio.getTecnico().reparar(servicio);
						System.out.println("El servicio de " + servicio.getCliente().getNombre() + " fue arreglado por "
								+ servicio.getTecnico() + " y tuvo un costo para la empresa de " + servicio.getCosto());
					} else
						System.out.println("No se ha diagnosticado el producto del cliente " + servicio.getCliente());

				} else
					System.out.println("Ya se ha reparado el producto!");
			} catch (Exception e) {
				
				System.out.println("No se ha generado el servicio con id: " + index);
			}
		} catch (Exception e) {
			
			System.out.println("El id del servicio no es correcto");
		}
	}

	static void solicitarReparacion() {
		System.out.println("Ingrese el id del cliente para solicitar la reparacion de su producto: ");
		try {
			int index = readInt();
			Cliente cliente = Cliente.getClientes().get(index);
			cliente.solicitarReparacion(cliente.getProductos().get(0));

			System.out.println("El cliente fue atendido exitosamente por " + cliente.getDependiente().getNombre()
					+ "!\n" + "Ya puede consultar en los servicios para iniciar su diagnostico o reparacion.");
		} catch (Exception e) {
			System.out.println("El id del cliente no es correcto");
		}
	}

	static void finalizarServicio() {
		try {
			System.out.println("Ingrese el id del servicio a finalizar: ");
			int index = readInt();
			Servicio servicio = Servicio.getServicios().get(index);

			if (servicio.isReparado()) {
				Dependiente dependiente = servicio.getDependiente();
				dependiente.finalizarServicio(servicio);
				System.out.println(servicio.getCliente().getRecibos().get(0));
				System.out.println("El servicio ya esta listo para ser cobrado");
			} else {
				System.out.println("El servicio no ha sido reparado aun y no se puede finalizar");
			}
		} catch (Exception e) {
			System.out.println("El id del servicio es incorrecto");
		}
	}

	static void cobrarServicio() {
		try {
			System.out.println("Ingrese el id del servicio a cobrar: ");
			int index = readInt();
			Servicio servicio = Servicio.getServicios().get(index);
			Dependiente dependiente = servicio.getDependiente();

			if (!servicio.isPagado()) {

				if (servicio.isReparado()) {
					dependiente.cobrarServicio(servicio);
					System.out.println("Se cobra el servicio por un total de "
							+ servicio.getCosto() * Dependiente.getMargenGanancia());
					System.out.println("En la caja registradora ahora hay "
							+ dependiente.getCajaRegistradora().getTotalIngresos() + " pesos");
				} else
					System.out.println("Aun no se ha reparado el producto, Que esperas?");
			} else {
				System.out.println("Ya se ha cobrado el servicio! Se lamenta la molestia.");

			}
		} catch (Exception e) {
			System.out.println("El id del cliente no es correcto");
		}
	}

	static void liquidar() {
		CajaRegistradora caja = Dependiente.getDependientes().get(0).getCajaRegistradora();
		double contador = 0;
		System.out
				.println("En la caja registradora hay " + Math.round(caja.getTotalIngresos()) + " antes de liquidar.");
		for (Empleado empleado : Empleado.getEmpleados()) {
			double carteraInicial = empleado.getCartera();

			empleado.cobrarSalario(caja);

			double carteraAhora = empleado.getCartera();
			double liquidado = carteraAhora - carteraInicial;
			contador += liquidado;
			System.out.println(
					"El " + empleado.toString() + " ha recibido " + Math.round(liquidado) + " por su trabajo.");
		}

		caja.setTotalIngresos(caja.getTotalIngresos() - contador);
		System.out.println("En la caja registradora quedan " + Math.round(caja.getTotalIngresos()));
	}

	public static Cliente generarCliente() {
		String[] nombres = { "Esteban", "Emilio", "Felipe", "Erik", "Alexander", "Jaime", "Alejandro", "Emiliana",
				"Dua lipa", "Erika", "Michael", "Juliana" };

		String[] nombreProductos = { "Laptop Legion 5", "Hp zbook 1", "Hp Omen 15", "Asus TUF Gaming", "HP XPS",
				"Macbook pro", "Lenovo Thinkpad", "Hp pavilion", "Notebook Gigabyte", "MSI Strike" };

		Componente[] componentes = { new Componente("Memoria 4g Kinsgton", true, PrecioComponente.RAM_4GB.getPrecio()),
				new Componente("Disco duro SSD 256gb", true, PrecioComponente.DISCO_DURO_SSD_256GB.getPrecio()),
				new Componente("Bateria laptop lenovo supercharger", true,
						PrecioComponente.BATERIA_LAPTOP_SUPERCHARGER.getPrecio()),
				new Componente("Procesador AMD", true, PrecioComponente.PROCESADOR_AMD.getPrecio()),
				new Componente("Display 15 pulgadas", true, PrecioComponente.DISPLAY_LAPTOP_15In.getPrecio()),
				new Componente("Memoria 8g Kinsgton", true, PrecioComponente.RAM_8GB.getPrecio()),
				new Componente("Disco duro HDD 512gb", true, PrecioComponente.DISCO_DURO_HDD_512GB.getPrecio()),
				new Componente("Bateria laptop lenovo", true, PrecioComponente.BATERIA_LAPTOP.getPrecio()),
				new Componente("Procesador Intel", true, PrecioComponente.PROCESADOR_INTEL.getPrecio()),
				new Componente("Display 17 pulgadas", true, PrecioComponente.DISPLAY_LAPTOP_17In.getPrecio()), };

		Random rand = new Random();
		Dependiente dependiente = Dependiente.getDependientes().get(0);
		List<Componente> productoComponentes = new ArrayList<Componente>();
		productoComponentes.add(componentes[rand.nextInt(rand.nextInt(componentes.length))]);
		productoComponentes.add(componentes[rand.nextInt(rand.nextInt(componentes.length))]);

		Producto producto = new Producto(nombreProductos[rand.nextInt(nombreProductos.length)], productoComponentes);

		List<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		double cartera = Math.round(450000 + 1000000 * Math.random());

		Cliente cliente = new Cliente(nombres[rand.nextInt(nombres.length)], "" + rand.nextInt(9999999), productos,
				dependiente, cartera);
		Cliente.getClientes().add(cliente);
		for (Componente componente : componentes) {
			Bodega.agregarComponente(componente);
		}
		return cliente;
	}

	static void menuDiagnosticar() {
		Cliente cliente;
		int opcion;
		do {
			System.out.println(" 1. Generar cliente");
			System.out.println(" 2. Solicitar reparacion");
			System.out.println(" 3. Diagnosticar producto");
			System.out.println(" 4. Volver al menu principal");

			opcion = (int) readInt();

			switch (opcion) {

			case 1:
				cliente = generarCliente();
				System.out
						.println("Se genero el cliente ID:" + (Cliente.getClientes().size() - 1) + cliente.toString());
				break;

			case 2:
				solicitarReparacion();
				break;

			case 3:
				diagnosticar();

			}
			if (opcion != 4) {
				
				System.out.println("\nPresione cualquier tecla para continuar");
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} while (opcion != 4);
	}

	public static void guardar() {
		Serializador.serializarTodo();
	}

	public static void cargar() {
		Deserializador.deserializarTodo();
	}

	public static void inicializar() {
		if (Dependiente.getDependientes().isEmpty())
			new Dependiente("Camila", 1237465, new CajaRegistradora());

		if (Tecnico.tecnicos.isEmpty())
			new Tecnico("Emilio", 987654);
	}
}
