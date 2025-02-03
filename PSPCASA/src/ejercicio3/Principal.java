package ejercicio3;

public class Principal {

	public static void main(String[] args) {
		Hilos[] hilos = new Hilos[5];
		
		for(int i = 0; i < hilos.length; i++) {
			hilos[i] = new Hilos("Hilo " + (i + 1), 10);
			hilos[i].start();
			
		}
		for (int j = 0; j < hilos.length; j ++) {
			try {
				hilos[j].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Programa finalizado.");
		
	}

}
