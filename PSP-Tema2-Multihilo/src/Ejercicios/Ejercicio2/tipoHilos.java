package Ejercicios.Ejercicio2;

public class tipoHilos extends Thread{

	private int tipo;

	public tipoHilos(int tipo) {
		super();
		this.tipo = tipo;
	}
	
	public void hiloTipoMetodo() {
	if(tipo==1) {
		
		for(int i = 1; i <= 30; i++) {
			System.out.println("Hilo tipo " + tipo + " -> " + i);
		}
	} else if (tipo == 2) {
        
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println("Hilo tipo " + tipo +  " -> " + c);
        }
    } else {
        System.out.println("Tipo no reconocido. Debe ser 1 o 2.");
    }
	}
	
	@Override
	public void run() {
		hiloTipoMetodo();
	}
}	

