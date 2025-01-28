package Ejercicios.Ejercicio3;

public class Hilos extends Thread{

	private int repeticiones; 

    public Hilos(String nombre, int repeticiones) {
        super(nombre);  
        this.repeticiones = repeticiones;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeticiones; i++) {
            System.out.println(getName() + " - Mensaje " + (i+1));
            int segundosAleatorios = (int)(Math.random() * 3) + 1; 
            try {
                Thread.sleep(segundosAleatorios * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (activeCount() == 2) {
            System.out.println(getName() + ": Soy el último superviviente!");
        }
    }
}