package p1;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ClasePrincipalEj1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int primero, segundo;//Primer y segundo valor que introducimos		
		Scanner sc = new Scanner(System.in);//Scanner que usaremos para escribir los numeros
		System.out.println("Introduceme el primer numero");
		primero = sc.nextInt();
		System.out.println("Introduceme el segundo número");
		segundo = sc.nextInt();
		//Bucle para que el primero sea menor
		while(primero >= segundo) {
			System.out.println("El segundo es menor o igual cambialo para que sea mayor");
			segundo = sc.nextInt();
		}
		//Hacemos el ForkJoin y llamamos a la clase para hacer el invoke
		ForkJoinPool fjp = new ForkJoinPool();
		ClaseForkJoin cfj = new ClaseForkJoin(primero, segundo);
		int resultado = fjp.invoke(cfj);
		System.out.println("Suma de los numeros primos: " + resultado);	

	}

}
