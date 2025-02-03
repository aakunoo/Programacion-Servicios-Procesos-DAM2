package ejercicioSemaforo;

public class HiloCoche implements Runnable {

    private Semaforo semaforo;
    private String nombreCoche;

    public HiloCoche(String nombreCoche, Semaforo semaforo) {
        this.nombreCoche = nombreCoche;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Esperamos 2 segundos antes de comprobar el semáforo
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Leemos el color de forma sincronizada
            String colorActual = semaforo.getColorSemaforo();

            if (colorActual.equals("VERDE") || colorActual.equals("AMARILLO")) {
                System.out.println(nombreCoche + " pasa el semáforo (" + colorActual + ")");
            } else {
                // colorActual.equals("ROJO")
                System.out.println(nombreCoche + " se detiene, semáforo en " + colorActual);
            }
        }
    }
}
