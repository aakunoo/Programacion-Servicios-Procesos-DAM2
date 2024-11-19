package parte2.Ejercicio4;

// Ejercicio hecho por Jerónimo Vicente.

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class SumaCuadradosForkJoinJeronimoVicente {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el tamaño del array: ");
		int tamaño = sc.nextInt();
		sc.close();
		
		// generar array con nums aleatorios entre 0 y 100
		
		int[] array = new int[tamaño];
		for (int i = 0; i < tamaño; i++) {
			array[i] = (int)(Math.random()* 100);
		}
		
		// creo el forkjoinpool y ejecuto tarea.
		
		ForkJoinPool pool = new ForkJoinPool();
		SumaCuadradosTarea tarea = new SumaCuadradosTarea(array, 0, tamaño);
		
		int sumTotal = pool.invoke(tarea);
		
		// mostrar resultado
		
		System.out.println("La suma total de los cuadrados es: " + sumTotal);
		
		pool.shutdown();

	}

}
