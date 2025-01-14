package ProgramacionConcurrente;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class EjercicioTimerConNotificacion {

    public static void main(String[] args) {
        if (!SystemTray.isSupported()) {
            System.out.println("El sistema no soporta notificaciones en la bandeja del sistema.");
            return;
        }

        Timer timer = new Timer();

        TimerTask recordatorio = new TimerTask() {
            @Override
            public void run() {
                mostrarNotificacion("Aviso", "LEVANTAAAAAAAAAAAAAAAA");
            }
        };
        timer.scheduleAtFixedRate(recordatorio, 1000, 2000);

        System.out.println("El programa se está ejecutando. Recibirás un recordatorio cada 30 minutos.");
    }

    public static void mostrarNotificacion(String titulo, String mensaje) {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image imagen = Toolkit.getDefaultToolkit().createImage("icono.png"); 
            TrayIcon trayIcon = new TrayIcon(imagen, "Recordatorio");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Recordatorio de actividad");
            tray.add(trayIcon);

            trayIcon.displayMessage(titulo, mensaje, TrayIcon.MessageType.INFO);

            tray.remove(trayIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}