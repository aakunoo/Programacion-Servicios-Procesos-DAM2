package alarma;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime tiempoAlarma = null;
		
		while(tiempoAlarma == null) {
			
			try {
				System.out.print("Introduce la hora de tu alarma (HH:MM:SS): ");
				String inputHora = sc.nextLine();
				
				tiempoAlarma = LocalTime.parse(inputHora, formatter);
				System.out.println("Alarma establecida para " + tiempoAlarma);
				
				} catch(DateTimeParseException e) {
					System.out.println("Formato inválido.");
				}
		}
		
		Alarma alarma = new Alarma(tiempoAlarma);

		
		sc.close();
	}

}
