package ejercicioBanco;

public class Banco {

	private final double[] cuentas;
	

	public Banco() {
		cuentas = new double[100];
		
		for(int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}
	}
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
		if(cuentas[cuentaOrigen] < cantidad) { // Evalua que el saldo no sea inferior a la transferencia.
			return;
		}
		
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen] -= cantidad; // Dinero que sale de la cuenta origen
		
		System.out.printf("Se transfieren %5.2f$ de la cuenta %d a la cuenta %d ", cantidad, cuentaOrigen, cuentaDestino);
	
		cuentas[cuentaDestino] += cantidad;
		
		System.out.printf("Saldo total: %10.2f%n ", getSaldoTotal());
			
	}
	
	public double getSaldoTotal() {
		
		double sumaCuentas = 0;
		
		for(double a: cuentas) {			
			sumaCuentas += a;
		}	
		return sumaCuentas;	
	}
	
}
