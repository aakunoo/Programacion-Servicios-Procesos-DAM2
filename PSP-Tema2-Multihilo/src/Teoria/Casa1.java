package Teoria;

public class Casa1 {

	public static void main(String[] args) {
		
		HilosVarios h1 = new HilosVarios();
		HilosVarios2 h2 = new HilosVarios2(h1);
		
		h2.start();
		h1.start();

		System.out.println("Tareas terminadas.");

	}

}

