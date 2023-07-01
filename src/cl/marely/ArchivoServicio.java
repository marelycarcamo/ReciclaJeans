package cl.marely;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author marely
 *
 */ 
public class ArchivoServicio {

	List<Producto> listaArchivo = new ArrayList<Producto>();	
	
	
	public List<Producto> getListaCargada() {
		return listaArchivo;
	}


	public void setListaCargada(List<Producto> listaArchivo) {
		this.listaArchivo = listaArchivo;
	}


	public void cargaDatos() {


		String path = "src/Directorio/ProductosImportados.csv";

		File file = new File(path);

		try {
			if (file.exists()) {
				if (file.canRead()) {

					try (Scanner sc = new Scanner(file)) {
						while (sc.hasNextLine()) {

							String linea = sc.nextLine();
							StringTokenizer atributo = new StringTokenizer(linea, ",");
							Producto producto = new Producto();
							// System.out.println(sc.nextLine());

							while (atributo.hasMoreElements()) {
								// empleado.setID(Integer.parseInt(atributo.nextElement().toString()));
								producto.setArticulo((atributo.nextElement().toString()));
								producto.setPrecio((atributo.nextElement().toString()));
								producto.setDescripcion((atributo.nextElement().toString()));
								producto.setCodigo((atributo.nextElement().toString()));
								producto.setTalla((atributo.nextElement().toString()));
								producto.setMarca((atributo.nextElement().toString()));
								producto.setColor((atributo.nextElement().toString()));
								listaArchivo.add(producto);
							}
						}
						sc.close();
					}

					listaArchivo.forEach(x -> System.out.println("\n" + x));
//			listaProducto.forEach(x -> System.out.println(x));
					if (listaArchivo.isEmpty()) {
						System.out.println("\n\n\t . . . La lista está vacía . . .");
					} else {
						System.out.println("\n\t------------------------------------------");
						System.out.println("\n\t . . . Datos cargados! . . .");
					}
					
				}
		
			} else {
				System.out.println(("\n\t . . . El archivo no existe !! . . ."));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
