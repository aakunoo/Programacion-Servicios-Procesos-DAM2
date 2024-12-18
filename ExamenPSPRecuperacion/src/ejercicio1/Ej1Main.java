package ejercicio1;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Ej1Main {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Introduce el primer numero: ");
		int numstart = sc.nextInt();
		System.out.println("Introduce el segundo número: ");
		int numend = sc.nextInt();
		
		// para comprobar que el primero es menor
		while(numstart > numend) {
			System.out.println("El segundo es menor o igual cambialo para que sea mayor: ");
			numend = sc.nextInt();
		}
		
		//Hacemos el ForkJoin y llamamos a la clase para hacer el invoke
		ForkJoinPool fjpool = new ForkJoinPool();
		
		Ej1ForkJoin clasefj = new Ej1ForkJoin(numstart, numend);
		
		int resultado = fjpool.invoke(clasefj);
		
		System.out.println("Suma de los numeros primos: " + resultado);	

	}

}

