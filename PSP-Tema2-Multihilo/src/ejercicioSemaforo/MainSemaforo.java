package ejercicioSemaforo;

import java.util.Timer;
import java.util.TimerTask;

public class MainSemaforo {
    public static void main(String[] args) {

        // 1. Creamos el semáforo con color inicial
        Semaforo semaforo = new Semaforo("ROJO");

        // 2. Creamos los hilos:
        // 2.1. Hilo de coche (Runnable)
        HiloCoche hiloCocheRunnable = new HiloCoche("Coche-1", semaforo);
        Thread hiloCoche = new Thread(hiloCocheRunnable);

        // 2.2. Hilo de peatón (extends Thread)
        HiloPeaton hiloPeaton = new HiloPeaton("Peatón-1", semaforo);

        // 3. Iniciamos ambos hilos
        hiloCoche.start();
        hiloPeaton.start();

        // 4. Creamos un Timer que cambiará el color del semáforo cada 5 segundos
        Timer temporizador = new Timer();

        // Array de colores para ciclar: ROJO -> VERDE -> AMARILLO
        final String[] coloresCiclo = {"ROJO", "VERDE", "AMARILLO"};
        
        // Usamos un array de un solo elemento para poder cambiarlo dentro de la clase anónima
        final int[] indice = {0};

        TimerTask tareaCambioColor = new TimerTask() {
            @Override
            public void run() {
                // Pasamos al siguiente color
                indice[0] = (indice[0] + 1) % coloresCiclo.length;
                String nuevoColor = coloresCiclo[indice[0]];
                // Establecemos el color en el semáforo de forma sincronizada
                semaforo.setColorSemaforo(nuevoColor);
            }
        };

        // Programamos la tarea: sin retraso inicial (0 ms) y repite cada 5000 ms (5 segundos)
        temporizador.schedule(tareaCambioColor, 0, 5000);

    }
}
