package teoria;

public class Metodo_waitFor_ProcesoPrincipal {

	public static void main(String[] args) {
		
		String[] infoProceso = {"java" , "teoria.Metodo_waitFor_ProcesoSecundario"};
		//String[] infoProceso = {"Notepad.exe" , "notas.txt"};
		
		try {
			Process proceso = Runtime.getRuntime().exec(infoProceso);
			int valorRetorno = proceso.waitFor();
			if (valorRetorno==0) {
                System.out.println("El proceso ha finalizado correctamente.");
            } else {
                System.out.println("El proceso ha finalizado con errores. Código de error: " + valorRetorno);     
            }
		} catch(Exception e) {
            e.printStackTrace();

		}

	}
}
