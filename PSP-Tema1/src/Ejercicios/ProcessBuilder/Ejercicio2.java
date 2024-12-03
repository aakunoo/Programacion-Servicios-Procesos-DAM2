package Ejercicios.ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio2 {
	
//Realiza un programa en java que utilizando la clase processbuilder ejecute un 
//ping a google.com y muestre los resultados por consola
	
	public static void main(String[] args) {
		
		ProcessBuilder processBuilder = new ProcessBuilder("ping", "github.com");
		
        try {
        	
        	// inicia proceso
            Process process = processBuilder.start();
            
            // Para obtener flujo de entrada (Los resultados del comando)
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String linea="";
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al intentar ejecutar el ping: " + e.getMessage());
        }
    }
}