package ejercicioBanco;

public class BancoSinSincronizar {

	public static void main(String[] args) {


		Banco banco = new Banco();
	
		for(int i = 0; i < 100; i ++) {
			
			ejecucionTransferencias et = new ejecucionTransferencias(banco, i, 2000); // i es el banco
			Thread t = new Thread(et);
			t.start();
		}

	}

}
