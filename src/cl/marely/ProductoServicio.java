package cl.marely;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author marely
 *
 */

public class ProductoServicio {
	ArchivoServicio archivoServicio = new ArchivoServicio();

	List<Producto> listaProducto = new ArrayList<Producto>();

	Utilidad utilidad = new Utilidad();

	public ProductoServicio(List<Producto> listaProducto) {
		super();
		this.listaProducto = listaProducto;
	}

	public ProductoServicio() {
		// TODO Auto-generated constructor stub
	}

	public List<Producto> getListaProducto() {

		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	@Override
	public String toString() {
		return "ProductoServicio [listaProducto=" + listaProducto + "]";
	}

	/*********************************************************
	 *
	 * .........L I S T A R
	 * 
	 * @param listaProducto
	 *
	 *********************************************************/
	public void listarDatos(List<Producto> listaProducto) {

		try {
			if (listaProducto.isEmpty()) {
				utilidad.mensaje("La lista se encuentra vacía!");

			} else {
				System.out.println("\n\n\n\n\t\t>-------<<<-- LISTA DE PRODUCTOS-->>>-------<\n");
				for (Producto p : listaProducto) {
					System.out.println("\t\tCodigo      : " + p.getCodigo().toString());
					System.out.println("\t\tArticulo    : " + p.getArticulo().toString());
					System.out.println("\t\tPrecio      : " + p.getPrecio().toString());
					System.out.println("\t\tDescripcion : " + p.getDescripcion().toString());
					System.out.println("\t\tTalla       : " + p.getTalla().toString());
					System.out.println("\t\tMarca       : " + p.getMarca().toString());
					System.out.println("\t\tColor       : " + p.getColor().toString());
					System.out.println("\n\t\t-----------------------------------------------\n");
				}

				utilidad.mensaje("La lista se cargo exitosamente !!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*******************************************************************
	 *
	 * ....................E D I T A R
	 * 
	 ********************************************************************/

	public void editarDatos(List<Producto> listaProducto) {

//		List<Producto> listaProducto = archivoServicio.getListaCargada();

		Scanner scEditar = new Scanner(System.in);
		String elCodigo;
		if (listaProducto.isEmpty()) {
			utilidad.mensaje("La lista se encuentra vacía!");
		} else {
			System.out.println("\n\t--------------------------------------------\n");
			Producto productoEncontrado = null;
			do {
				System.out.print("\n\tIngrese CODIGO DE PRODUCTO que desea actualizar: ");
				elCodigo = scEditar.nextLine();
				boolean flag = false;

				for (Producto producto : listaProducto) {

					if (producto.getCodigo().equals(elCodigo)) {
						productoEncontrado = producto;
						System.out.println("\nPRODUCTO ENCONTRADO : " + productoEncontrado);
						flag = !flag;
					}
				}
				utilidad.mensaje((flag) ? "CODIGO ENCONTRADO !!" : "EL CODIGO NO EXISTE !!");
			} while (productoEncontrado == null);

			int opcion = 0;
			boolean flag = false;
			System.out.println("\n\t>-------<<<-- MENU EDICION-->>>-------<\n");
			System.out.println("\t -  CODIGO      :" + productoEncontrado.getCodigo());
			System.out.println("\t -  ARTICULO    :" + productoEncontrado.getArticulo());
			System.out.println("\t[1] PRECIO      :" + productoEncontrado.getPrecio());
			System.out.println("\t[2] DESCRIPCION :" + productoEncontrado.getDescripcion());
			System.out.println("\t[3] TALLA       :" + productoEncontrado.getTalla());
			System.out.println("\t[4] MARCA       :" + productoEncontrado.getMarca());
			System.out.println("\t[5] COLOR       :" + productoEncontrado.getColor());
			do {
				System.out.print("\n\n\tIngrese el número del item que desea actualizar\n\t[1][2][3][4][5] :");
				try {
					opcion = Integer.parseInt(scEditar.nextLine());
					flag = ((opcion < 1) || (opcion > 5)) ? flag : !flag;
				} catch (InputMismatchException e) {
					System.out.println("\n\tINGRESE LAS OPCIONES ENTRE [1 - 5]");
				}
			} while (flag == false);
			String dato = "";
			try {
				switch (opcion) {
				case 1:
					System.out.print("\n\tNUEVO PRECIO: ");
					dato = scEditar.nextLine();
					if (dato != "") {
						productoEncontrado.setPrecio(dato);
					}
					break;

				case 2:
					System.out.print("\n\tNUEVA DESCRIPCION : ");
					dato = scEditar.nextLine();
					if (dato != "") {
						productoEncontrado.setDescripcion(dato);
					}
					break;

				case 3:
					System.out.print("\n\tNUEVA TALLA: ");
					dato = scEditar.nextLine();
					if (dato != "") {
						productoEncontrado.setTalla(dato);
					}
					break;

				case 4:
					System.out.print("\n\tNUEVA MARCA : ");
					dato = scEditar.nextLine();
					if (dato != "") {
						productoEncontrado.setMarca(dato);
					}
					break;

				case 5:
					System.out.print("\n\tNUEVO COLOR : ");
					dato = scEditar.nextLine();
					if (dato != "") {
						productoEncontrado.setColor(dato);
					}
					break;
				}
				utilidad.mensaje((dato != "") ? "Información actualizada\n\n" + productoEncontrado
						: "La información NO fue actualizada\n\n" + productoEncontrado);

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scEditar.nextLine();
		}
	}
}
