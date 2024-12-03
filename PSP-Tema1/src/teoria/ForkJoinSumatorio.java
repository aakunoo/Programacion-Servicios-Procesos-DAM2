package teoria;

import java.util.concurrent.RecursiveTask;

class ForkJoinSumatorio extends RecursiveTask<Integer> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 50; // Umbral para dividir la tarea
    private int[] arr;
    private int start, end;

    public ForkJoinSumatorio(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Si el tamaño es pequeño, calcula la suma secuencialmente
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            // Si el tamaño es grande, divide la tarea en subtareas
            int middle = (start + end) / 2;
            ForkJoinSumatorio subTask1 = new ForkJoinSumatorio(arr, start, middle);
            ForkJoinSumatorio subTask2 = new ForkJoinSumatorio(arr, middle, end);

            // Divide y ejecuta ambas tareas en paralelo
            subTask1.fork();
            subTask2.fork();

            // Combina los resultados de ambas subtareas
            return subTask1.join() + subTask2.join();
        }
    }
}


