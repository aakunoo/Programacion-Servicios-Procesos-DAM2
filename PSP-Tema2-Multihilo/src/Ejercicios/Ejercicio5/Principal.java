package Ejercicios.Ejercicio5;

public class Principal {
	public static void main(String[] args) {
		
        // saldo inicial 40€
        Cuenta cuenta = new Cuenta(40);

        // dos hilos que accederan a la misma cuenta
        HiloSacarDinero h1 = new HiloSacarDinero("\nPersona 1", cuenta);
        HiloSacarDinero h2 = new HiloSacarDinero("\nPersona 2", cuenta);

        
        h1.start();
        h2.start();
    }
}
