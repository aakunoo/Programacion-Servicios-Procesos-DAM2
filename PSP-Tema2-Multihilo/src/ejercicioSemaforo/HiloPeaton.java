package ejercicioSemaforo;

public class HiloPeaton extends Thread {

    private Semaforo semaforo;

    public HiloPeaton(String nombrePeaton, Semaforo semaforo) {
        super(nombrePeaton);  // Asigna el nombre al hilo
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Esperamos 3 segundos antes de comprobar el semáforo
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String colorActual = semaforo.getColorSemaforo();
            if (colorActual.equals("ROJO")) {
                System.out.println(getName() + " cruza la calle (semáforo en " + colorActual + ")");
            } else {
                System.out.println(getName() + " espera, semáforo en " + colorActual);
            }
        }
    }
}
