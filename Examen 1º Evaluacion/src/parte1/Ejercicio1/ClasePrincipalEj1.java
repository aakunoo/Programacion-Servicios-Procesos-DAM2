package parte1.Ejercicio1;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ClasePrincipalEj1 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in); //Scanner que usaremos para escribir los numeros
		
		System.out.println("Introduce el primer numero");
		int numstart = sc.nextInt();
		System.out.println("Introduce el segundo número");
		int numend = sc.nextInt();
		
		//Bucle para que el primero sea menor
		while(numstart > numend) {
			System.out.println("El segundo es menor o igual cambialo para que sea mayor");
			numend = sc.nextInt();
		}
		
		//Hacemos el ForkJoin y llamamos a la clase para hacer el invoke
		ForkJoinPool fjp = new ForkJoinPool();
		
		ClaseForkJoin cfj = new ClaseForkJoin(numstart, numend);
		
		int resultado = fjp.invoke(cfj);
		
		System.out.println("Suma de los numeros primos: " + resultado);	

	}

}
