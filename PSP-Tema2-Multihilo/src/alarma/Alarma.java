package alarma;

import java.time.LocalTime;

public class Alarma implements Runnable {

	private final LocalTime tiempoAlarma;
	
	public Alarma(LocalTime tiempoAlarma) {
		this.tiempoAlarma = tiempoAlarma;
	}




	@Override
	public void run() {
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora);
	}
	

}
