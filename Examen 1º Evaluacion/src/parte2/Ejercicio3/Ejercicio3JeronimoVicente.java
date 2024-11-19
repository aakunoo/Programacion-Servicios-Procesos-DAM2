package parte2.Ejercicio3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio3JeronimoVicente {

	public static void main(String[] args) {
		
		String listarArchivos = "cmd.exe /c dir C:\\Users\\Public";
		
		ejecutarComando(listarArchivos, "Archivos y carpetas en el directorio especificado.");
		
		 String comdProcesos = "cmd.exe /c tasklist";
		
		ejecutarComando(comdProcesos, "Procesos en ejecución: ");
	}

	

	private static void ejecutarComando(String cmdo, String descripcion) {
		
		try {
			ProcessBuilder pb = new ProcessBuilder (cmdo.split(""));
			
			Process proceso = pb.start();
			BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		
			System.out.println("\n***********************************************");
			System.out.println(descripcion);
			System.out.println("***********************************************");
			
			String linea;
			while ((linea = lector.readLine()) != null) {
				
				System.out.println(linea);
			}
				
				int codigoSalida = proceso.waitFor();
				
				System.out.println("\nEl proceso mostrar procesos en ejecución terminó con el código: " + codigoSalida);
			
			} catch (Exception e) {
				System.out.println("Ocurrió un error al ejecutar el comando: " + e.getMessage());
			}
	}
}


