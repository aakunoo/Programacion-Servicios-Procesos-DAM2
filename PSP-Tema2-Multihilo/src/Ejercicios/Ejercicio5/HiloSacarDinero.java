package Ejercicios.Ejercicio5;

public class HiloSacarDinero extends Thread{

	private Cuenta cuenta;
	private String nombre;
	
	
	public HiloSacarDinero(String nombre, Cuenta cuenta) {
		super(nombre);
		this.cuenta = cuenta;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < 4; i++) {
			
			 try {
	                Thread.sleep((long)(Math.random() * 1000));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			
			cuenta.retirarDinero(nombre, 10);
			
		}
		
	}
	
}
