package ejercicioBanco;

public class ejecucionTransferencias extends Thread implements Runnable{
	
	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMaxima;
	
	public ejecucionTransferencias(Banco b, int de, double max) {
		this.banco = b;
		this.cuentaOrigen = de;
		this.cantidadMaxima = max;
	}

	@Override
	public void run() {
		try {
		while(true) {
			
			int cuentaDestino = (int)(Math.random()*100);
			double cantidad = cantidadMaxima * Math.random();
			banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
			
			
				Thread.sleep((int)(Math.random()*1000));
			} 
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}
	
}
