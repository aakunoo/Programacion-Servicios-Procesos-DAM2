package Teoria;

// Cada ratón es un hilo, ya que extiende la clase Thread
public class Raton extends Thread {
	private String nombre;
	private int tiempoAlimentacion;
	
	
	public Raton(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public void comer() {
		
		try {
			System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);

		// Detiene la ejecución del hilo durante tiempoAlimentacion segundos. La clase Thread usa milisegundos, por eso se multiplica por 1000
			Thread.sleep(tiempoAlimentacion * 1000);
			System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
			
		} catch (InterruptedException e) {
			
		}
	}

/**
run(): Es el punto de entrada del hilo. Cuando llamamos a start(), 
se ejecuta el método run() en un nuevo hilo.*/
	
	@Override
	public void run() {
		this.comer();
	}
	
	public static void main(String[] args) {
		
		Raton laura = new Raton("Laura", 4);
		Raton zurron = new Raton("Zurron", 5);
		Raton jero = new Raton("Jero", 3);
		Raton zar = new Raton("Zar", 6);
		
		laura.start();
		zurron.start();
		jero.start();
		zar.start();	
	}		
}
