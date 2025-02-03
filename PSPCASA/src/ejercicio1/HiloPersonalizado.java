package ejercicio1;

public class HiloPersonalizado extends Thread implements Runnable {
	
	private int numVeces;
	

	public HiloPersonalizado(String nombre, int numVeces) {
		super(nombre);
		this.numVeces = numVeces;
	}

	public void imprimirDatos() {
		
		System.out.println("Hola soy el hilo " + this.getName() 
											+ " con id " + this.threadId()
											+ ", prioridad " + this.getPriority() 
											+ " y en mi grupo hay " + this.getThreadGroup().activeCount() + " hilos.");
		
	}

	@Override
	public void run() {
		for(int i = 0; i < numVeces; i++) {
			imprimirDatos();
		}
	}

}
