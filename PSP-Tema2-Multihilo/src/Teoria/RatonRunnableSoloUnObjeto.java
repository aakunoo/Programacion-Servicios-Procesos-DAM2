package Teoria;

import java.util.ArrayList;

public class RatonRunnableSoloUnObjeto implements Runnable {

    private String nombre;
    private int tiempoAlimentacion;

    public RatonRunnableSoloUnObjeto(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.comer();
    }

    public static void main(String[] args) {

        RatonRunnableSoloUnObjeto Zia = new RatonRunnableSoloUnObjeto("Zia", 6);
        ArrayList<Thread.State> estadosHilo = new ArrayList<>();
        Thread h = new Thread(Zia);

        estadosHilo.add(h.getState());

        h.start();

        while (h.getState() != Thread.State.TERMINATED) {
            Thread.State estadoActual = h.getState();
            
            if (!estadosHilo.contains(estadoActual)) {
                estadosHilo.add(estadoActual);
            }
        }

        if (!estadosHilo.contains(h.getState())) {
        	estadosHilo.add(h.getState());
        }
        
        System.out.println("\nEstados registrados:");
        for (Thread.State estado : estadosHilo) {
            System.out.println(estado);
        }
    }
}
