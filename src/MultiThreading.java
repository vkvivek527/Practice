import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreading {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        long startTime = System.currentTimeMillis();

        for(int i = 1; i <= 10; i++){
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(factorial(finalI));
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            System.out.println("Exception occurred....");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken  " + (endTime - startTime));
    }

    public static long factorial(int num){
        long res = 1L;
        for(int i = 1; i <= num; i++){
            res = res * i;
        }
        return res;
    }

}
