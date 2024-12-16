package parte2.Ejercicio4;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ClasePrincipalEj4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la longitud que quieres que tenga tu array de números");
		int longitud = sc.nextInt();
		
		//Bucle para que la longitud sea mayor a 0 y no de problemas
		
		while(longitud <= 0) {
			System.out.println("Introduce una longitud mayor a 0: ");
			longitud = sc.nextInt();
			
		}
		
		int [] numeros = new int [longitud]; //Array que pasaremos al constructor de la clase
		
		//Bucle donde rellenamos el array y nos aseguramos que los numeros aleatorios sean int
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random()*100);
		}
		
		ForkJoinPool fjp = new ForkJoinPool(); //Llamamos a forkjoinpool
		
		ClaseForkJoinEj4 cfj = new ClaseForkJoinEj4(numeros, 0, numeros.length);//Llamamos a la clase y le pasamos los parametros al constructor.
		
		int resultado = fjp.invoke(cfj);//Invocamos la tarea
		
		System.out.println("La suma de los cuadrados es: " + resultado);

	}

}
