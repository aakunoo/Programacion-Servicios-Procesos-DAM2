package parte1.Ejercicio1;

//Ejercicio realizado por Jerónimo Vicente Vidal.

import java.util.concurrent.RecursiveTask;

public class SumaPrimosTaskJeronimoVicente extends RecursiveTask <Integer> {
	private static final int UMBRAL = 1000;
	private int inicio, fin;
	
	
	public SumaPrimosTaskJeronimoVicente(int inicio, int fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
	}

	@Override
	protected Integer compute() {
		
		if (fin - inicio <= UMBRAL) {
			
			// es un caso base, se calcula directamente:
			int suma = 0;
			for (int i = inicio; i<= fin; i++) {
				if(SumaPrimosForkJoinJeronimoVicente.esPrimo(i)) {
					suma += 1;
				}
			}
			
			return suma;
		}else {
			
			// dividir en 2 subtareas el rango
			int medio = (inicio + fin)/2;
			
			SumaPrimosTaskJeronimoVicente tarea1 = new SumaPrimosTaskJeronimoVicente(inicio,medio);
			SumaPrimosTaskJeronimoVicente tarea2 = new SumaPrimosTaskJeronimoVicente(medio,fin);
			
			tarea1.fork(); // ejecutar primera tarea en paralelo
			
			int resultado2 = tarea2.compute(); // calcular segunda tarea directamente
			int resultado1 = tarea1.join(); // espera al resultado de la primera tarea.
			
			return (resultado1 + resultado2);
		}
	}

	
}
