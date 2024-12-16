package parte1.Ejercicio1;

import java.util.concurrent.RecursiveTask;

public class ClaseForkJoin extends RecursiveTask<Integer>{
	
	private static final long UIDVersion = 1L;
	private int numstart, numend;
	private static final int UMBRAL = 1000; // UMBRAL
	
	//Constructor de la clase
	public ClaseForkJoin(int numstart, int numend) {
		super();
		this.numstart = numstart;
		this.numend = numend;
	}
	@Override
	protected Integer compute() {

		int suma = 0;//Variable donde se almacenara la suma
		
		
		if(numend-numstart <= UMBRAL) { // Caso base: si el rango es pequeño, calcular directamente
			
			//Bucle donde llamamos al metodo esPrimo y si es verdadero se añade a la suma
			
			for(int i = numstart; i <= numend; i++) {
				if(esPrimo(i) == true) {
					suma+= i;
				}
			}
			
			return suma;
			
		}else {
			
			// Caso recursivo: dividir la tarea en dos subtareas
			int medio = (numstart + numend) / 2; // Calculamos la mitad
			
			//Llamamos a las clases
			ClaseForkJoin subtarea1 = new ClaseForkJoin(numstart, medio);
			ClaseForkJoin subtarea2 = new ClaseForkJoin(medio, numend);
			
			//Dividimos las tareas en diferentes hilos
			subtarea1.fork();
			subtarea2.fork();
			
			//Juntamos los resultados y devolvemos
			int resultado1 = subtarea1.join();
			int resultado2 = subtarea2.join();
			return(resultado1 + resultado2);
		}

	}
	//Metodo para saber numeros primos
	private boolean esPrimo(int number) {
		if (number <= 1) return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;	
		}
}
