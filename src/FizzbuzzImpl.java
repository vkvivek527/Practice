import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class FizzbuzzImpl {
    public static void main(String[] args) {

        IntConsumer intConsumer = System.out::println;

        FizzBuzz fizzBuzz = new FizzBuzz(15);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> fizzBuzz.number(intConsumer));
             executorService.submit(fizzBuzz::fizz);
             executorService.submit(fizzBuzz::buzz);
             executorService.submit(fizzBuzz::fizzbuzz);

             executorService.shutdown();

    }
}
