package Ejercicios.Ejercicio3;

public class Principal {

	 public static void main(String[] args) {
	        Hilos[] hilos = new Hilos[5];

	        for (int i = 0; i < 5; i++) {
	            hilos[i] = new Hilos("Hilo " + (i + 1), 5);
	            hilos[i].start();
	        }

	        for (int i = 0; i < 5; i++) {
	            try {
	                hilos[i].join();  
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        System.out.println("Programa finalizado!");
	    }
	}