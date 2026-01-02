package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFuturePractice
{
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(4);
        CompletableFuture<List<Integer>> f1 = new CompletableFuture<List<Integer>>().supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return Arrays.asList(1,2,3,4,5);
        },es);

        CompletableFuture<List<Integer>> f2 = new CompletableFuture<List<Integer>>().supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return Arrays.asList(6,7,8,9,10);
        },es);
        CompletableFuture<List<Integer>> res = f1.thenCombine(f2,(l1,l2) ->{
            List<Integer> res1 = new ArrayList<>();
            res1.addAll(l1);
            res1.addAll(l2);
            return res1;
        });
        System.out.println(res.join());
        System.out.println("main thread");
    }
}

class Task1 implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() throws Exception {
        return List.of(1,2,3,4,5);
    }
}

class Task2 implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() throws Exception {
        return List.of(1,2,3,4,5);
    }
}



