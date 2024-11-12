package Ejercicios;

import java.util.Scanner;
 
public class Prueba2 {
	public static boolean FechaValida(int dia, int mes, int año) {
		boolean boo=true;
 
		if (mes < 1 || mes > 12 || año <= 0 || año >= 2025 || dia <= 0) {
            return false;
        }
 
        
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (dia > 31) {
                    boo = false;
                }
                break;
            case 4: case 6: case 9: case 11:
                if (dia > 30) {
                    boo = false;
                }
                break;
            case 2:
                boolean bisiesto = (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
                if (bisiesto) {
                    if (dia > 29) {
                        boo = false;
                    }
                } else {
                    if (dia > 28) {
                        boo = false;
                    }
                }
                break;
        }
		
		return boo;
	}
	public static void main(String[] args) {
		
		System.out.println("Introduce día,mes y año");
		Scanner sc= new Scanner(System.in);
		System.out.println("Día:");
		int dia=sc.nextInt();
		System.out.println("Mes:");
		int mes=sc.nextInt();
		System.out.println("Año:");
		int año=sc.nextInt();
		boolean bo =FechaValida(dia,mes,año);
		System.out.println(bo);
		sc.close();
			}
		
		
	}
 