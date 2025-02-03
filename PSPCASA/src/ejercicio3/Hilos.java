package ejercicio3;

public class Hilos extends Thread implements Runnable {
	
	private int repeticiones;

	public Hilos(String nombre, int repeticiones) {
		super(nombre);
		this.repeticiones = repeticiones;
	}
	
	
	public void ultimoSuperviviente() {
		for(int i = 0; i < repeticiones; i++) {
			System.out.println(getName() + "- Mensaje " + (i+1));
			int segundosAleatorios = (int)(Math.random()*10)+1;
			try {
				Thread.sleep(segundosAleatorios * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
		if (activeCount() == 2) {
            System.out.println(getName() + ": Soy el último superviviente!");
		}
	}
	
	@Override
	public void run() {
		ultimoSuperviviente();
	}

}
