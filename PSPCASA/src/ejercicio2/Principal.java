package ejercicio2;

public class Principal {

	public static void main(String[] args) {
		TipoHilo h1 = new TipoHilo(1);
		TipoHilo h2 = new TipoHilo(2);
		
		h1.start();
		
		try {
			h1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		h2.start();

	}

}
