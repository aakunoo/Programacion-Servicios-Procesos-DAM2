package ejercicio3;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ClaseMainEj3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Longitud que quieres que tenga el array: ");
		int l = sc.nextInt(); // longitud
		
		
		if(l<0) {
			System.out.println("Introduce un numero mayor de 0. ");
			l = sc.nextInt();
			
		}
		
		int [] tamarray = new int [l]; //Array que pasaremos al constructor de la clase
		
		// rellenamos array y comprobamos que los nums randoms sean enteros.
		
		for(int i = 0; i < tamarray.length; i++) {
			tamarray[i] = (int) (Math.random()*100);
		}
		
		ForkJoinPool fjpool = new ForkJoinPool(); 
		
		ClaseForkJoinEj3 clasefj = new ClaseForkJoinEj3(tamarray, 0, tamarray.length);
		
		int resultado = fjpool.invoke(clasefj);
		
		sc.close();
		
		System.out.println("La suma de los cuadrados es: " + resultado);

	}

}
