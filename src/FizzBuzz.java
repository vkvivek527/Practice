import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    int n;
    Semaphore intSema;
    Semaphore fizzSema;
    Semaphore buzzSema;
    Semaphore fizzbuzzSema;
    FizzBuzz(int n){
        this.n = n;
        intSema = new Semaphore(1);
        fizzSema = new Semaphore(0);
        buzzSema = new Semaphore(0);
        fizzbuzzSema = new Semaphore(0);
    }
    /*
• "fizzbuzz" if i is divisible by 3 and 5,
• "fizz" if i is divisible by 3 and not 5,
• "buzz" if i is divisible by 5 and not 3, or
• if i is not divisible by 3 or 5.
    */
    public void fizz(){
        try {
            for(int i = 1; i <= n; i++){
                if(i % 3 == 0 && i % 5 != 0){
                    fizzSema.acquire();
                    System.out.println("fizz");
                    intSema.release();
                }
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public void buzz(){
        try {
            for(int i = 1; i <= n; i++){
                if(i % 3 != 0 && i % 5 == 0){
                    buzzSema.acquire();
                    System.out.println("buzz");
                    intSema.release();
                }
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public void fizzbuzz() {
        try {
            for(int i = 1; i <= n; i++){
                if(i % 3 == 0 && i % 5 == 0){
                    fizzbuzzSema.acquire();
                    System.out.println("fizzbuzz");
                    intSema.release();
                }
            }
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public void number (IntConsumer intConsumer) {
        try{
     for(int i = 1; i <= n; i++){
         intSema.acquire();
         if(i % 3 == 0 && i % 5 == 0){
             fizzbuzzSema.release();
         }
         else if(i % 5 == 0){
             buzzSema.release();
         }else if(i % 3 == 0){
             fizzSema.release();
         }else {
             intConsumer.accept(i);
             intSema.release();
         }
     }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}
