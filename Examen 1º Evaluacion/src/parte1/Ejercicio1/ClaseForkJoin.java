package p1;

import java.util.concurrent.RecursiveTask;

public class ClaseForkJoin extends RecursiveTask<Integer>{
	private static final long UIDVersion = 1;
	private int numero1, numero2;
	private static final int hilos = 1000;//Umbral que se pide
	//Constructor de la clase
	public ClaseForkJoin(int numero1, int numero2) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int suma = 0;//Variable donde se almacenara la suma
		//Para calcular el umbral
		if(numero2-numero1 <= hilos) {
			//Bucle donde llamamos al metodo esPrimo y si es verdadero se añade a la suma
			for(int i = numero1; i <= numero2;i++) {
				if(esPrimo(i) == true) {
					suma+=i;
				}
			}
			return suma;
		}else {
			int medio = (numero1+numero2)/2;//Dividimos el resultado por la mitad
			//Llamamos a las clases
			ClaseForkJoin subtarea1 = new ClaseForkJoin(numero1, medio);
			ClaseForkJoin subtarea2 = new ClaseForkJoin(medio, numero2);
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
