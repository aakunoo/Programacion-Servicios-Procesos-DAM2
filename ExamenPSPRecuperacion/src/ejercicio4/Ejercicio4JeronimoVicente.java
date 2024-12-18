package ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4JeronimoVicente {

	public static void main(String[] args) {
		
try {

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
			pb.directory(new File("C:\\Users\\Public")); // directorio de trabajo
			
			Process p = pb.start(); // Inicia proceso 
			BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			System.out.println("***************************************");
			System.out.println("Archivos en el directorio especificado: ");
			System.out.println("***************************************");
			
			consola(lector);
			int cmdsal = p.waitFor();
			System.out.println("***************************************");
			System.out.println("El proceso 'dir' terminó con el código: " + cmdsal);
			System.out.println("***************************************");
			
			System.out.println("Procesos en ejecución: ");
			System.out.println("\nConfiguración IP de Windows ");
			System.out.println("***************************************");
			pb = new ProcessBuilder ("cd.exe", "/c", "tasklist");
			p = pb.start();
			//cmdsal = p.waitFor();
			//p.getInputStream();
			//consola(lector);
			

	} catch (IOException | InterruptedException e) {
	
	}
}		
			
	public static void consola (BufferedReader lector) {
		String linea;
		try {
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
		
		