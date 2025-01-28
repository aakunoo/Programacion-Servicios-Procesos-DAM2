package Ejercicios.Ejercicio5;

public class Cuenta {
	
	int saldo;

	public Cuenta(int saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	public synchronized void retirarDinero(String nombre, int cantidad) {
        System.out.println(nombre + " va a retirar " + cantidad + " euros. Saldo actual: " + saldo);
	
        if (saldo >= cantidad) {
        	
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        	int saldoAnterior = saldo;
        	saldo -= cantidad;
        	
        	System.out.println(nombre + " ha retirado " + cantidad + " euros. "
        			+ "\nSaldo anterior: " + saldoAnterior + "\nSaldo actual: " + saldo);
        } else {
        	
        	System.out.println("Error. No se puede retirar dinero. " +
        	"\nSu saldo actual es de " + saldo);
        	
        }
        
	
	}
}
