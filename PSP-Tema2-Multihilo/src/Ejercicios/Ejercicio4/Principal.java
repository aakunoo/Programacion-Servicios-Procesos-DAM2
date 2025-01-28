package Ejercicios.Ejercicio4;

public class Principal {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			Hilos hilo = new Hilos("Hilo " + i);
            hilo.start();
		}

	}

}
