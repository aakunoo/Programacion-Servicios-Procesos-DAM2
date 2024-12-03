package Ejercicios.Ejercicio2ForkJoinConMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class llamadaForkJoinContadorConMenu {

	public static void main(String[] args) {
		
		  ForkJoinPool fjpool = new ForkJoinPool();
	      Scanner scanner = new Scanner(System.in);      
	      String texto = "";

	        System.out.println("Seleccione una opción:");
	        System.out.println("1. Introducir el texto desde la consola");
	        System.out.println("2. Leer el texto desde un fichero");
	        int opcion = scanner.nextInt();
	        scanner.nextLine();  
	        
	        switch (opcion) {
            case 1:
                System.out.println("Introduce el texto del cual quieras contar las palabras.");
                texto = scanner.nextLine();
                break;

            case 2:
                System.out.println("Introduce la ruta del fichero: ");
                String ruta = scanner.nextLine();
                

                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(ruta));
                    String linea;

                    linea = br.readLine();
                    while (linea != null) {
                        texto += linea + " ";
                        linea = br.readLine();
                    }

                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                    fjpool.shutdown();
                    scanner.close();
                    return;  
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                    } catch (IOException e) {
                        System.out.println("Error al cerrar el archivo: " + e.getMessage());
                    }
                }
                break;

            default:
                System.out.println("Opción no válida.");
                fjpool.shutdown();
                scanner.close();
                return; 
	        }
	        
	        System.out.println("Introduce la palabra que deseas contar:");
	        String palabra = scanner.nextLine();
	        scanner.close();
	        
	        String[] palabras = texto.split("\\s");
	        
	        forkJoinContadorConMenu task = new forkJoinContadorConMenu(palabra, palabras);
	        int result = fjpool.invoke(task);
	        
	        System.out.println("La palabra '" + palabra + "' se encontró " + result + " veces en el texto.");

	
	        fjpool.shutdown();
	}
}























