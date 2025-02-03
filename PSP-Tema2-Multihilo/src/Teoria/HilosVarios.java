package Teoria;

public class HilosVarios extends Thread implements Runnable {
	
	
	@Override
	public void run() {
		for(int i = 0; i<15; i++) {
			System.out.println("Ejecutando hilo "+ getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
