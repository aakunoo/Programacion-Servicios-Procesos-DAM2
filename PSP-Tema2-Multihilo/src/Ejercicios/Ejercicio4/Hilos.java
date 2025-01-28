package Ejercicios.Ejercicio4;

public class Hilos extends Thread {

	public Hilos(String nombre) {
		super(nombre);
	}

	public void hilosMetodo() {
		
		while(true) {
			System.out.println("Soy el bucle " + getName() + " y estoy trabajando.");
			
			int segsAleatorios = (int)(Math.random() * 10) + 1;
			
			try {
				Thread.sleep(segsAleatorios * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		
		hilosMetodo();
	}
		
	
}
