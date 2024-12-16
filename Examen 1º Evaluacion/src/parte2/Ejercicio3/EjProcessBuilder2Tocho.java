package parte2.Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjProcessBuilder2Tocho {

	public static void main(String[] args) throws IOException {
	
		try {
			
			// "/c": Indica que se ejecutará un comando y el terminal se cerrará después
			
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
			pb.directory(new File("C:\\Users\\Public")); // Directorio de trabajo
			
			Process p = pb.start(); // pb.start(): Inicia el proceso (cmd.exe /c dir).
			BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			System.out.println("***************************************");
			System.out.println("Archivos en el directorio especificado: ");
			System.out.println("***************************************");
			
			mostrarSalidaConsola(lector);
			int comandoSalida = p.waitFor();
			System.out.println("El proceso dir terminó con el código: " + comandoSalida);
			
	
			pb = new ProcessBuilder ("cd.exe", "/c", "tasklist");
			p = pb.start();
			lector = new BufferedReader (new InputStreamReader(p.getInputStream()));
			System.out.println("***************************************");
			System.out.println("Procesos en ejecucion:");
			mostrarSalidaConsola(lector);
			System.out.println("***************************************");
			
			comandoSalida = p.waitFor();
			
			System.out.println("***************************************");
			System.out.println("El proceso tasklist terminó con el código: " + comandoSalida);
			System.out.println("***************************************");
		
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public static void mostrarSalidaConsola (BufferedReader lector) {
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