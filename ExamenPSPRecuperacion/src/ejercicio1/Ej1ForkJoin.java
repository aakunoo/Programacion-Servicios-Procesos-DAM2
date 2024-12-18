package ejercicio1;

import java.util.concurrent.RecursiveTask;

public class Ej1ForkJoin extends RecursiveTask<Integer>{
	
	private static final long SERIALUIDVERSION = 1L;
	private int numstart, numend;
	private static final int UMBRAL = 1000; // UMBRAL
	
	public Ej1ForkJoin(int numstart, int numend) {
		super();
		this.numstart = numstart;
		this.numend = numend;
	}
	@Override
	protected Integer compute() {

		int suma = 0; 
		
		if(numend-numstart <= UMBRAL) {
			
			// llamamos al metodo esPrimo y si es verdadero se añade a la suma
			
			for(int i = numstart; i <= numend; i++) {
				if(esPrimo(i) == true) {
					suma+= i;
				}
			}
			
			return suma;
			
		}else {
			
			// dividir la tarea en dos subtareas
			int mid = (numstart + numend) / 2; // Calculamos la mitad
			
			// llamamos a las clases
			Ej1ForkJoin starea1 = new Ej1ForkJoin(numstart, mid);
			Ej1ForkJoin starea2 = new Ej1ForkJoin(mid, numend);
			

			starea1.fork();
			starea2.fork();
			int result1 = starea1.join();
			int result2 = starea2.join();
			return(result1 + result2);
		}

	}
	// metodo dado en examen
	private boolean esPrimo(int number) {
		if (number <= 1) return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;	
		}
}
