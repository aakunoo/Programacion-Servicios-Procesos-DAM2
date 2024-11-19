package parte1.Ejercicio1;

//Ejercicio realizado por Jerónimo Vicente Vidal.

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class SumaPrimosForkJoinJeronimoVicente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el rango");
		
		// pido el primer y segundo numero para el rango al usuario.
		System.out.println("Introduce el primer número: ");
		int inicio = sc.nextInt();
		System.out.println("Introduce el segundo número: ");
		int fin = sc.nextInt();
		
		// indico que el primer numero debe ser mayor o igual al segundo para seguir con el programa.
		if (inicio >= fin) {
			System.out.println("El primer numero debe ser menor que el segundo.");
			System.out.println("Fin del programa.");
			return;
			
		}
		
		// instancio un forkjoin pool y la clase sumaprimostask para las tareas.
		ForkJoinPool pool = new ForkJoinPool();		
		SumaPrimosTaskJeronimoVicente tarea = new SumaPrimosTaskJeronimoVicente(inicio,fin);
		
		int suma = pool.invoke(tarea);
		
		System.out.println("La suma de los números primos en el rango es: " + suma);
		
		pool.shutdown();
	}
	
	// funcion para comprobar si es primo (dada en el examen).
	public static boolean esPrimo(int number) {
		if (number <=1) return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0)
				return false;
		}
		return true;
	}
		

}
