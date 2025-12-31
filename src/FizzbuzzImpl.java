import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class FizzbuzzImpl {
    public static void main(String[] args) {

        IntConsumer intConsumer = System.out::println;

        FizzBuzz fizzBuzz = new FizzBuzz(7);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
             executorService.submit(() -> fizzBuzz.fizz(intConsumer));
             executorService.submit(() -> fizzBuzz.buzz(intConsumer));
             executorService.submit(() -> fizzBuzz.fizzbuzz(intConsumer));
             executorService.submit(() -> fizzBuzz.number(intConsumer));
             executorService.shutdown();

    }
}
