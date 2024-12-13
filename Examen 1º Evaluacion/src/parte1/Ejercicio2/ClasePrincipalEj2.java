package p1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClasePrincipalEj2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);//Scanner que lo usaremos para escribir
		File fichero = new File("C:\\Users\\Public\\Ejercicio2Parte2.txt");//Ruta del fichero
		//Lanzamos la excepcion y comprobamos que el fichero fue creado correctamente
		if(fichero.createNewFile()) {
			System.out.println("El fichero se creo correctamente");
		}else {
			System.out.println("El fichero no se creo correctamente o ya existia");
		}
		System.out.println("Introduce un texto");
		String texto = sc.nextLine();//Variable que usaremos para introducir el texto en el fichero
		//Lanzamos la excepcion
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
		bw.write(texto);//Escribimos el texto
		bw.close();//Cerramos el Writer para que se introduzca correctamente
		ProcessBuilder pb = new ProcessBuilder("notepad.exe", "Ejercicio2Parte2.txt");//Constructor del proceso
		pb.directory(new File("C:\\Users\\Public\\"));//Cambiamos el directorio del proceso
		Process ps = pb.start();//Iniciamos el proceso
		
		
	}

}
