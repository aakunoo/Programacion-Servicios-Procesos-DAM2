package ejercicio2;

public class TipoHilo extends Thread implements Runnable {
	
	private int tipo;
	
	
	public TipoHilo(int tipo) {
		super();
		this.tipo = tipo;
	}

	public void hilosMetodo() {
		
		if(tipo == 1) {
			for(int i = 1; i <= 30; i++) {
				System.out.println("Hilo tipo " + tipo + " -> " + i);
			}
		} else if(tipo == 2) {
			for(char c = 'a'; c<='z'; c++) {
				System.out.println("Hilo tipo " + tipo + " -> " + c);
			}
		}else {
			System.out.println("Tipo no válido.");
		}
	}



	@Override
	public void run() {
		hilosMetodo();
	}

}
