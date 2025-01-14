package ProgramacionConcurrente;

import java.util.Timer;
import java.util.TimerTask;

public class SistemaRiego extends TimerTask {

	@Override
	public void run() {
		System.out.println("Regando...");
	}
	
	public static void main(String[] args) {
		Timer temporizador = new Timer();
		temporizador.schedule(new SistemaRiego(), 5000, 2000);
	}

}
