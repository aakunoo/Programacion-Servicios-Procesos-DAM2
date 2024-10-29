package ejercicios.Ejercicio2ForkJoinV2;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

import ejercicios.Ejercicio2ForkJoin.forkJoinContador;

public class llamadaForkJoinContadorv2 {

	public static void main(String[] args) {
		
		ForkJoinPool fjpool = new ForkJoinPool();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el texto del cual quieras contar las letras.");
		String texto = scanner.nextLine();
        System.out.println("Introduce la palabra que deseas contar:");
        String palabra = scanner.nextLine();
        
		scanner.close();
		
		String[] palabras = texto.split("\\s");
		forkJoinContadorv2 task = new forkJoinContadorv2(palabra,palabras);
		
		int result = fjpool.invoke(task);
		System.out.println("La palabra '" + palabra + "' se encontró " + result + " veces en el texto.");

		fjpool.shutdown(); 
	}

}
