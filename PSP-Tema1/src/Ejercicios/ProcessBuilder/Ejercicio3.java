package Ejercicios.ProcessBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Ejercicio3 {

	public static void main(String[] args) {
		

        Scanner scanner = new Scanner(System.in);
        List<String> nombres = new ArrayList<>();

        System.out.println("***********************************************************************");
        System.out.println("Introduce 4 nombres y los ordenaré:");

        for (int i = 0; i < 4; i++) {
            String nombre = scanner.nextLine();
            nombres.add(nombre);
        }

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "sort");
        processBuilder.redirectErrorStream(true);

        try {

            Process process = processBuilder.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            for (String nombre : nombres) {
                writer.write(nombre);
                writer.newLine();
            }
            writer.close();

     
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("***********************************");
            System.out.println("Salida ordenada:");
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.println("Ha ocurrido un error al ejecutar el comando 'sort': " + e.getMessage());
        }

        System.out.println("***********************************************************************");
        scanner.close();
    }
}
