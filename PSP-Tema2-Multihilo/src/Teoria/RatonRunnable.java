package Teoria;

// Cada ratón es un hilo, ya que extiende la clase Thread
public class RatonRunnable implements Runnable  {
	private String nombre;
	private int tiempoAlimentacion;
	
	
	public RatonRunnable(String nombre, int tiempoAlimentacion) {
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
		
		RatonRunnable laura = new RatonRunnable("Laura", 4);
		RatonRunnable zurron = new RatonRunnable("Zurron", 5);
		RatonRunnable jero = new RatonRunnable("Jero", 3);
		RatonRunnable zar = new RatonRunnable("Zar", 6);
		
		new Thread(laura).start();
		new Thread(zurron).start();
		new Thread(jero).start();
		new Thread(zar).start();	
	}			
}
