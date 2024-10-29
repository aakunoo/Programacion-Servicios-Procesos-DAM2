package ejercicios.Ejercicio2ForkJoinConMenu;

import java.util.concurrent.RecursiveTask;

public class forkJoinContadorConMenu extends RecursiveTask <Integer>{

	private static final int THRESHOLD = 10;
	private String palabra;
	private int start, end;
	private String[] arr;

	// Constructor para la tarea inicial
	public forkJoinContadorConMenu(String palabra, String[] arr) {
		this.palabra = palabra;
		this.arr = arr;
		this.start = 0;
		this.end = arr.length;
	}

	// Constructor para las subtareas
	public forkJoinContadorConMenu(String palabra, String[] arr, int start, int end) {
		this.palabra = palabra;
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int count = 0;

		if (end - start <= THRESHOLD) {
			for (int i = start; i < end; i++) {
				if (arr[i].equals(palabra)) {
					count++;
				}
			}
			return count;
			
		} else {
			
			int middle = (start + end) / 2;
			forkJoinContadorConMenu subTask1 = new forkJoinContadorConMenu(palabra, arr, start, middle);
            forkJoinContadorConMenu subTask2 = new forkJoinContadorConMenu(palabra, arr, middle, end);
            
            subTask1.fork();
            subTask2.fork();
            
            int result1 = subTask1.join();
            int result2 = subTask2.join();

            return result1 + result2;
            
		
		}
		
		
	}
}
