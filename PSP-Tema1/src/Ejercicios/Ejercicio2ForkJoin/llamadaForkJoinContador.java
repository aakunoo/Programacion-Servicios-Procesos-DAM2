package Ejercicios.Ejercicio2ForkJoin;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class llamadaForkJoinContador {

	public static void main(String[] args) {
		
		ForkJoinPool fjpool = new ForkJoinPool();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el texto del cual quieras contar las letras.");
		String texto = scanner.nextLine();
        System.out.println("Introduce la palabra que deseas contar:");
        String palabra = scanner.nextLine();
        
		scanner.close();
		
		 forkJoinContador task = new forkJoinContador(texto, palabra, 0, texto.length());
		
		 try {
	            int palabraRepe = fjpool.invoke(task); 
	            System.out.println("La palabra '" + palabra + "' se encontró " + palabraRepe + " veces en el texto.");
	        } catch (Exception e) {
	            System.out.println("Error durante la ejecución: " + e.getMessage());
	        } finally {
	            fjpool.shutdown(); 
	        }
	    }
}