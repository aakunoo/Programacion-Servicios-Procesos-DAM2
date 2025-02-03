package ejercicioSemaforo;

public class Semaforo {
    private String colorSemaforo;  // Puede ser "ROJO", "VERDE" o "AMARILLO"

    public Semaforo(String colorInicial) {
        this.colorSemaforo = colorInicial;
    }

    // Método sincronizado para cambiar el color
    public synchronized void setColorSemaforo(String nuevoColor) {
        this.colorSemaforo = nuevoColor;
        System.out.println("Semáforo cambiado a: " + nuevoColor);
    }

    // Método sincronizado para obtener el color actual
    public synchronized String getColorSemaforo() {
        return colorSemaforo;
    }
}
