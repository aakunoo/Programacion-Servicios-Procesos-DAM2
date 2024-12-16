package parte2.Ejercicio4;

import java.util.concurrent.RecursiveTask;

public class ClaseForkJoinEj4 extends RecursiveTask<Integer>{
	private static final long UIDVersion = 1;
	private int [] numeros;
	private int start, end;
	private static final int UMBRAL = 1000; //Umbral
	
	//Constructor de la clase
	public ClaseForkJoinEj4(int[] numeros, int start, int end) {
		super();
		this.numeros = numeros;
		this.start = start;
		this.end = end;
	}
	
	
	@Override
	protected Integer compute() {

		int suma = 0;
		
		if(end - start <= UMBRAL) {

			for(int i = start; i < end; i++) {
				suma += (numeros[i]*numeros[i]);
			}
			
			return suma;
			
		}else {
			
			int cuarto = (start+end)/4; //Dividimos la longitud en cuatro partes
			
			//Llamamos a las clases para realizar las tareas
			ClaseForkJoinEj4 subtarea1 = new ClaseForkJoinEj4(numeros, start, cuarto); //Primer cuarto
			ClaseForkJoinEj4 subtarea2 = new ClaseForkJoinEj4(numeros, cuarto, cuarto+cuarto); //Segundo cuarto
			ClaseForkJoinEj4 subtarea3 = new ClaseForkJoinEj4(numeros, cuarto+cuarto, cuarto+cuarto+cuarto); //Tercer curto
			ClaseForkJoinEj4 subtarea4 = new ClaseForkJoinEj4(numeros, cuarto+cuarto+cuarto, end); //Último cuarto
			
			int resultado1 = subtarea1.compute(); //Proceso en hilo principal
			
			//Procesos en hilos divididos
			subtarea2.fork();
			subtarea3.fork();
			subtarea4.fork();
			
			//Juntamos los procesos
			int resultado2 = subtarea2.join();
			int resultado3 = subtarea3.join();
			int resultado4 = subtarea4.join();
			
			//Lo que nos devuelve
			return (resultado1 + resultado2 + resultado3 + resultado4);
		}
		
	}
	
}
