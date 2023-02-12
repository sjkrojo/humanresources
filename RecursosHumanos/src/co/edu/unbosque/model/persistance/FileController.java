package co.edu.unbosque.model.persistance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileController {

	 private FileOutputStream archivo_salida;
	 private ObjectOutputStream escritor;

	 private FileInputStream archivo_entrada;
	 private ObjectInputStream lector;

	public void initSalida(String nombreclase) {
		try {
			archivo_salida = new FileOutputStream("src/co/edu/unbosque/model/persistance/"+nombreclase+".ini");
		} catch (FileNotFoundException e) {
			System.out.println("Error al crear el archivo");
			System.out.println(e.getMessage());
		}

		try {
			escritor = new ObjectOutputStream(archivo_salida);
		} catch (IOException e) {
			System.out.println("Error al acceder al archivo");
			System.out.println(e.getMessage());
		}
	}

	public void escribirSerializado(Object o) {
		if (escritor != null) {
			try {
				escritor.writeObject(o);
			} catch (IOException e) {
				System.out.println("error al escribir los datos en el archiuvo");
				System.out.println(e.getMessage());
			}
		}
	}


	public void cerrarSerializado() {
		if (escritor != null) {
			try {
				escritor.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar el archivo");
				System.out.println(e.getMessage());
			}
		}
	}

	public void initEntrada(String nombreclase) {
		try {
			archivo_entrada = new FileInputStream("src/co/edu/unbosque/model/persistance/"+nombreclase+".ini");
		} catch (FileNotFoundException e) {

			System.out.println("Error al abrir el archivo, Archivo serializado no existe, esperando primera lectura");
			//System.out.println(e.getMessage());
		}

		try {
			lector = new ObjectInputStream(archivo_entrada);
		} catch (IOException e) {
			System.out.println("Error al leer al archivo");
			System.out.println(e.getMessage());
		}
	}

	// paso 2: leer
	public Object leerSerializado() {
		Object aux = null;
		if (lector != null) {
			try {
				aux = lector.readObject();

			} catch (IOException e) {
				System.out.println("Error al leer el archivo");
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("Error al convertir los datos");
				System.out.println(e.getMessage());
			}
		}
		return aux;

	}

	// paso 3: cerrar
	public  void cerrarLector() {
		if (lector != null) {
			try {
				lector.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
				System.out.println(e.getMessage());
			}
		}
	}

}
