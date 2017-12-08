package fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    final long[] array;
    final int low, high;
    private static final int THRESHOLD = 10;    // 子任务的限制, 超出THRESHOLD将被分割

    public SumTask(long[] array, int lo, int hi) {
        this.array = array;
        this.low = lo;
        this.high = hi;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if (high - low < THRESHOLD) {
            // 执行任务
            for (int i = low; i < high; ++i)
                sum += array[i];

            return sum;
        } else {

            // 分割任务
            int mid = (low + high) >>> 1;

            // 调用子任务
            return new SumTask(array, low, mid).compute() +  new SumTask(
                    array, mid, high).compute();
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long[] array = new long[100];
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        SumTask task = new SumTask(array, 0, array.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Long> sum = forkJoinPool.submit(task);
        System.out.println(sum.get());
    }

}
