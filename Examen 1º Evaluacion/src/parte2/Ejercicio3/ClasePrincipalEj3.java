package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClasePrincipalEj3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dir");//Primer constructor de proceso
		//Cambiamos el directorio del proceso
		pb.directory(new File("C:\\Users\\Public"));
		//Lanzamos las excepciones e iniciamos el programa con el primer proceso
		Process ps = pb.start();
		//Lanzamos la excepcion y leemos lo que nos devuelva el proceso
		BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		String linea;//Variable que se usara para leer la devolucion del comando
		System.out.println("Archivos en el directorio especificado:\n");
		//Bucle para leer el contenido que nos paso el Reader
		while((linea = br.readLine())!=null) {
			System.out.println(linea);
		}
		System.out.println("\nEl proceso mostrar archivos terminó con el código: " + ps.exitValue());//Mostramos mensaje para saber si todo fue bien
		
		//Segunda parte que vamos a mostrar
		System.out.println("\nProcesos en ejecucion: ");
		ProcessBuilder pb2 = new ProcessBuilder("cmd.exe","/c","tasklist");//Segundo constructor de proceso
		//Lanzamos las excepciones e iniciamos el programa con el segundo proceso
		Process ps2 = pb2.start();
		//Lanzamos la excepcion y leemos lo que nos devuelva el proceso
		BufferedReader br2 = new BufferedReader(new InputStreamReader(ps2.getInputStream()));
		String linea2;//Variable que se usara para leer la devolucion del comando
		System.out.println("Archivos en el directorio especificado:\n");
		//Bucle para leer el contenido que nos paso el reader
		while((linea2 = br2.readLine())!=null) {
			System.out.println(linea2);
		}
		System.out.println("\nEl proceso mostrar procesos en ejecución terminó con el código: " + ps2.exitValue());//Mostramos mensaje para saber si todo fue bien
	}

}
