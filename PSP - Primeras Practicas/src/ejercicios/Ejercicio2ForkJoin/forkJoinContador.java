package Ejercicios.Ejercicio2ForkJoin;

import java.util.concurrent.RecursiveTask;

public class forkJoinContador extends RecursiveTask<Integer> {

	   private static final int THRESHOLD = 50;
	    private String texto;
	    private String palabra;
	    private int start, end;


	    public forkJoinContador(String texto, String palabra, int start, int end) {
	        this.texto = texto;
	        this.palabra = palabra;
	        this.start = start;
	        this.end = end;
	    }

	    @Override
	    protected Integer compute() {

	        if (end - start <= THRESHOLD) {
	            String fragmento = texto.substring(start, end);
	            return contarPalabra(fragmento, palabra);
	        } else {
	            int middle = (start + end) / 2;
	            forkJoinContador subTask1 = new forkJoinContador(texto, palabra, start, middle);
	            forkJoinContador subTask2 = new forkJoinContador(texto, palabra, middle, end);

	            subTask1.fork();
	            subTask2.fork();

	            return subTask1.join() + subTask2.join();
	        }
	    }

	    private int contarPalabra(String fragmento, String palabra) {
	        int count = 0;
	        int index = 0;


	        while ((index = fragmento.indexOf(palabra, index)) != -1) {
	            count++;  
	            index += palabra.length(); 
	        }

	        return count;
	    }
	}