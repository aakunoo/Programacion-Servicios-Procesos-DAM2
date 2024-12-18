package ejercicio3;

import java.util.concurrent.RecursiveTask;

public class ClaseForkJoinEj3 extends RecursiveTask<Integer>{
	private static final long SERIALUIDVERSION = 1L;
	private int [] tamarray;
	private int inicio, fin;
	private static final int UMBRAL = 1000; //Umbral
	
	public ClaseForkJoinEj3(int[] tamarray, int inicio, int fin) {
		super();
		this.tamarray = tamarray;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	
	@Override
	protected Integer compute() {

		int suma = 0;
		
		if(fin - inicio <= UMBRAL) {

			for(int i = inicio; i < fin; i++) {
				suma += (tamarray[i] * tamarray[i] );
			}
			
			return suma;
			
		}else {
			
			int c4 = (inicio + fin) / 4; // lo dividimos en 4 partes
			
			// Llamamos a las clases para realizar las tareas
			ClaseForkJoinEj3 subtarea1 = new ClaseForkJoinEj3(tamarray, inicio, c4); // 1/4
			ClaseForkJoinEj3 subtarea2 = new ClaseForkJoinEj3(tamarray, c4, c4+c4); // 2/4
			ClaseForkJoinEj3 subtarea3 = new ClaseForkJoinEj3(tamarray, c4+c4, c4+c4+c4); //3/4 
			ClaseForkJoinEj3 subtarea4 = new ClaseForkJoinEj3(tamarray, c4+c4+c4, fin); //4/4
			
			int resultado1 = subtarea1.compute(); //Proceso en hilo principal
			
			//Procesos en hilos divididos
			subtarea2.fork();
			subtarea3.fork();
			subtarea4.fork();
			
			//Juntamos procesos
			int resultado2 = subtarea2.join();
			int resultado3 = subtarea3.join();
			int resultado4 = subtarea4.join();
			

			return (resultado1 + resultado2 + resultado3 + resultado4);
		}
		
	}
	
}
