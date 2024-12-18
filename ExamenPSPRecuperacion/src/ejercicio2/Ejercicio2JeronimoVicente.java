package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2JeronimoVicente {

	public static void main(String[] args) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		
		String rutaArch = "C:\\Users\\Public\\Ejercicio2Parte2.txt";
		
		System.out.println("Introduce el texto que quieras guardar en el archivo: ");
		
		String texto = sc.nextLine();
		sc.close();
		
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArch))){
			
			escritor.write(texto);
			System.out.println("Texto guardado en el archivo correctamente.");
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
			return;
			
		}
		
		// Para abrir archivo con bloc de notas instancio ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder("notepad.exe", rutaArch);
		
		try {
			
			pb.start();
			System.out.println("Se abrió el archivo correctamente en el bloc de notas. ");
			
		} catch (IOException e) {
			
			System.out.println("Error al abrir el archivo en el bloc de notas: " + e.getMessage());
		}
	}
}
