package Teoria;

public class HilosVarios2 extends Thread implements Runnable {
	
	private Thread hilo;
	
	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	@Override
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
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