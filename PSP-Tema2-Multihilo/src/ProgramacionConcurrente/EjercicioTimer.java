package ProgramacionConcurrente;

import java.util.Timer;
import java.util.TimerTask;

public class EjercicioTimer extends TimerTask {

	@Override
	public void run() {
		System.out.println("Es momento de levantarse.");
	}
	public static void main(String[] args) {
		 Timer timer = new Timer();
		 timer.schedule(new EjercicioTimer(), 1000, 2000);

	}

}
