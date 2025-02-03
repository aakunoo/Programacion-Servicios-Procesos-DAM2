package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		for(int i = 0; i <= 10; i++) {
			HiloPersonalizado hilo = new HiloPersonalizado("Hilo " + i, i);
			hilo.start();
		}

	}

}
