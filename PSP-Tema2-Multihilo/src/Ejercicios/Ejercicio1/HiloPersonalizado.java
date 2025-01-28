package Ejercicios.Ejercicio1;

public class HiloPersonalizado extends Thread {

    private int numVeces;
    
    public HiloPersonalizado(String nombre, int numVeces) {
     
        super(nombre);
        this.numVeces = numVeces;
    }
    
    private void imprimirDatos() {
  
        System.out.println("Hola soy " + this.getName() +
                           " con id " + this.threadId() +
                           ", prioridad " + this.getPriority() +
                           " y en mi grupo hay " + getThreadGroup().activeCount() + " hilos");
    }


    @Override
    public void run() {
        for (int i = 0; i < numVeces; i++) {
            imprimirDatos();
            
        }  
    }
}

