package ejercicios.Ejercicio1ForkJoin;

import java.util.concurrent.RecursiveTask;

class ForkJoinMaximo extends RecursiveTask<Integer> {
    
    private static final int UMBRAL = 50;  
    private int[] arr;
    private int start, end;

    public ForkJoinMaximo(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= UMBRAL) {
            int maximo = arr[start];
            for (int i = start + 1; i < end; i++) {
                if (arr[i] > maximo) {
                    maximo = arr[i];  
                }
            }
            return maximo;
        } else {
  
            int middle = (start + end) / 2;
            ForkJoinMaximo subTask1 = new ForkJoinMaximo(arr, start, middle);
            ForkJoinMaximo subTask2 = new ForkJoinMaximo(arr, middle, end);

            subTask1.fork();
            subTask2.fork();

            int maximoSubTask1 = subTask1.join();
            int maximoSubTask2 = subTask2.join();

            return Math.max(maximoSubTask1, maximoSubTask2);
        }
    }
}
