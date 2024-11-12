package Ejercicios.ProcessBuilder;

import java.io.IOException;

public class Ejercicio1 {
	
	// Realiza un programa en java que utilizando la clase processbuilder arranque el navegador 
	// google chrome, concretamente arranque en la web de educacyl.

	public static void main(String[] args) {
		
		String link = "https://www.educa.jcyl.es/";
		
		 ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", link);
		 try {
	       
	            processBuilder.start();
	            System.out.println("Google Chrome se ha iniciado con la página de Educacyl.");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al intentar abrir Google Chrome: " + e.getMessage());
	        }
	    }
	}