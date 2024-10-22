package teoria;

import java.util.concurrent.ForkJoinPool;

public class LlamadaForkJoin {
	
	    public static void main(String[] args) {
	    	ForkJoinPool pool = new ForkJoinPool();  // Crea un ForkJoinPool
	        try {
		    	int[] arr = new int[100];
		        for (int i = 0; i < arr.length; i++) {
		            arr[i] = i + 1;  // Inicializa el array con valores del 1 al 100
		        }
	
		        
		        ForkJoinSumatorio task = new ForkJoinSumatorio(arr, 0, arr.length);
	
		        int result = pool.invoke(task);  // Inicia la ejecución de la tarea
		        System.out.println("La suma es: " + result);
		        
		        	
	        }catch (Exception e) {
	        	System.out.println("Ha fallado" + e.getMessage());
	        }finally {
	        	pool.close();
	        }
	    }
}