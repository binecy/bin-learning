package fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class IncrementTask extends RecursiveAction {
    final long[] array;
    final int low, high;
    private static final int THRESHOLD = 10;    // 子任务的限制, 超出THRESHOLD将被分割

    public IncrementTask(long[] array, int lo, int hi) {
        this.array = array;
        this.low = lo;
        this.high = hi;
    }

    @Override
    protected void compute() {
        if (high - low < THRESHOLD) {
            // 执行任务
            for (int i = low; i < high; ++i)
                array[i]++;
        } else {
            // 分割任务
            int mid = (low + high) >>> 1;
            // 调用子任务
            invokeAll(new IncrementTask(array, low, mid), new IncrementTask(
                    array, mid, high));
        }
    }

    public static void main(String[] args) {
        long[] arr = new long[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        IncrementTask task = new IncrementTask(arr, 0, arr.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task);

        for (long i : arr) {
            System.out.print(i + "    ");
        }
    }
}
