package Ejercicios.Ejercicio1ForkJoin;

import java.util.concurrent.ForkJoinPool;

public class llamadaForkJoin {
    
    public static void main(String[] args) {
        try (ForkJoinPool pool = new ForkJoinPool()) {
			int[] arr = new int[1000];  
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random() * 1000);  
			}

			ForkJoinMaximo task = new ForkJoinMaximo(arr, 0, arr.length);

			try {
			    int maximo = pool.invoke(task); 
			    System.out.println("El valor máximo es: " + maximo);
			} catch (Exception e) {
			    System.out.println("Error durante la ejecución: " + e.getMessage());
			} finally {
			    pool.close(); 
			}
		}
    }
}
