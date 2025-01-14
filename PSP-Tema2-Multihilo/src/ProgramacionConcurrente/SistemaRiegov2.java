package ProgramacionConcurrente;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SistemaRiegov2 implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Regando...");
	}

	public static void main(String[] args) {

		SistemaRiego sr = new SistemaRiego();
		ScheduledExecutorService stp = Executors.newSingleThreadScheduledExecutor();
		stp.scheduleAtFixedRate(sr, 1, 2, TimeUnit.SECONDS);
		System.out.println("Sistema de riego configurado.");
	}

}
