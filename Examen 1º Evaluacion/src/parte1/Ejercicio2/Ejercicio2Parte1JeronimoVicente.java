package parte1.Ejercicio2;

// Ejercicio realizado por Jerónimo Vicente Vidal.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2Parte1JeronimoVicente {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// la ruta del archivo.
		String rutaArch = "C:\\Users\\Public\\Ejercicio2Parte2.txt";
		
		// pido al usuario introducir el texto que quiere introducir.
		System.out.println("Introduce el texto qué quieras guardar en el archivo: ");
		String texto = sc.nextLine();
		sc.close();
		
		// para escribir texto en el archivo hago un try with resources para evitarme fallos luego de cierre etc.
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArch))){
			
			escritor.write(texto);
			
			System.out.println("Texto guardado en el archivo correctamente. ");
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
			return;
		}
		
		// para abrir archivo con notepad instancio processbuilder.
		ProcessBuilder pb = new ProcessBuilder("notepad.exe", rutaArch);
		
		try {
			
			// inicio proceso.
			pb.start();
			
			System.out.println("El archivo se ha abierto en el bloc de notas.");
		} catch (IOException e) {
			
			System.out.println("Error al abrir el archivo en el bloc de notas: " + e.getMessage());
			
		}
	}

}
