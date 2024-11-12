package Ejercicios;

import java.util.Scanner;

public class Prueba1 {

	   public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la cantidad de dinero en euros (con decimales): ");
        double cantidad = scanner.nextDouble();

    
        int totalCentimos = (int) (cantidad * 100); // Se multiplica por 100 para pasarlo a centimos.

        System.out.println("Cantidad ingresada: " + cantidad + " euros");
        if (totalCentimos >= 200) {
            System.out.println("Monedas de 2 euros: " + (totalCentimos / 200));
            totalCentimos -= (totalCentimos / 200) * 200;
        }
        if (totalCentimos >= 100) {
            System.out.println("Monedas de 1 euro: " + (totalCentimos / 100));
            totalCentimos -= (totalCentimos / 100) * 100;
        }
        if (totalCentimos >= 50) {
            System.out.println("Monedas de 50 centimos: " + (totalCentimos / 50));
            totalCentimos -= (totalCentimos / 50) * 50;
        }
        if (totalCentimos >= 20) {
            System.out.println("Monedas de 20 centimos: " + (totalCentimos / 20));
            totalCentimos -= (totalCentimos / 20) * 20;
        }
        if (totalCentimos >= 10) {	
            System.out.println("Monedas de 10 centimos: " + (totalCentimos / 10));
            totalCentimos -= (totalCentimos / 10) * 10;
        }
        if (totalCentimos >= 5) {
            System.out.println("Monedas de 5 centimos: " + (totalCentimos / 5));
            totalCentimos -= (totalCentimos / 5) * 5;
        }
        if (totalCentimos >= 2) {
            System.out.println("Monedas de 2 centimos: " + (totalCentimos / 2));
            totalCentimos -= (totalCentimos / 2) * 2;
        }
        if (totalCentimos >= 1) {
            System.out.println("Monedas de 1 centimo: " + totalCentimos);
        }
        scanner.close();
    }

 
}

