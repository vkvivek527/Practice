import java.util.concurrent.*;

public class ExecutorPractice {

    public static void main(String[] args){
//        ExecutorService es = Executors.newSingleThreadExecutor();
//        Future<Integer> res =  es.submit(() -> {
//            return 1;
//        });
//        try {
//            System.out.println(res.get());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        es.shutdown();

//        ExecutorService ec = Executors.newFixedThreadPool(4);
//        Future<String> res = ec.submit(() ->{
//            System.out.println("Executing task");
//            return "Completed";
//        });
//        res.cancel(false);
//        System.out.println(res.isDone());
//        try{
//            if(!res.isCancelled()){
//                System.out.println(res.get());
//            }
//        }catch(InterruptedException | ExecutionException e){
//            System.out.println("exception occured");
//        }
//       ec.shutdown();

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(() -> {
            System.out.println("working....");
        },4,
                2,
                TimeUnit.SECONDS);

    }

}
