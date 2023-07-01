/**
 * 
 */
package cl.marely;

import java.util.Scanner;
import java.lang.NumberFormatException;


/**
 * @author marely
 *
 */
public class Menu {


	public void menu() {
		
		ArchivoServicio archivoServicio = new ArchivoServicio();
		ProductoServicio productoServicio = new ProductoServicio();
		Utilidad utilidad = new Utilidad();
		int opcion;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				opcion = 0;
				try {
					System.out.println("\n\t\t------- M E N U --------\n");
					System.out.println("\t\t [1] Listar Producto");
					System.out.println("\t\t [2] Editar Producto");
					System.out.println("\t\t [3] Importar Datos");
					System.out.println("\t\t [4] Salir");

					System.out.print("\n\t\t Ingrese la opción: ");
					
					opcion = Integer.parseInt(sc.nextLine());
					
		
				switch (opcion) {
				case 1:
					productoServicio.listarDatos(archivoServicio.listaArchivo);
					break;
				case 2:
					productoServicio.editarDatos(archivoServicio.listaArchivo);
					break;
				case 3:
					archivoServicio.cargaDatos();
					break;
				case 4:
					utilidad.tiempoEspera("Estas saliendo del programa", 300);
					System.out.print("\n\n\t\t< < < FIN DEL PROGRAMA > > >");
					System.exit(0);
					break;
				default:
					System.out.println("\n\tIngrese un valor numérico [1 - 4]\n");
					break;
				}
				}catch(NumberFormatException e) {
					System.out.println("\n\tIngrese un valor numérico [1 - 4]\n");
				
				}

			} while (opcion != 4);
		}
	
	}

}
