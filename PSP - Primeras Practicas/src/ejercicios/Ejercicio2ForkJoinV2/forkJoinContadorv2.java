package ejercicios.Ejercicio2ForkJoinV2;

import java.util.concurrent.RecursiveTask;


public class forkJoinContadorv2 extends RecursiveTask<Integer> {

	private static final int THRESHOLD = 50;

	private String palabra;
	private int start, end;
	private String[] arr;

	public forkJoinContadorv2(String palabra, String[] arr) {
		super();
		this.palabra = palabra;
		this.arr = arr;
		this.start = 0;
		this.end = arr.length;
	}

	public forkJoinContadorv2(String palabra, String[] arr, int start, int end) {
		super();
		this.palabra = palabra;
		this.arr = arr;
		this.start = start;
		this.end = end;
		
	}

	@Override
	protected Integer compute() {
		int cont = 0;
		if (end - start <= THRESHOLD) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals(palabra)) {
					cont++;
				}				
			}	
			return cont;
		}else {
			int middle = (start + end) / 2;
            forkJoinContadorv2 subTask1 = new forkJoinContadorv2(palabra, arr, start, middle);
            forkJoinContadorv2 subTask2 = new forkJoinContadorv2(palabra, arr, middle, end);

            subTask1.fork();
            subTask2.fork();

            int uno = subTask1.join();
            int dos = subTask2.join();
            
            
            	return uno+dos;
            }
            	
            }
			
		
	}


