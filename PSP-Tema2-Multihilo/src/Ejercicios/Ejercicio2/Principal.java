package Ejercicios.Ejercicio2;

public class Principal {

	public static void main(String[] args) {

		tipoHilos h1 = new tipoHilos(1);
		tipoHilos h2 = new tipoHilos(2);

		
		h1.start();
		h2.start();
	}

}
