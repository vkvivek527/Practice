package multithreading;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class XenosImplementation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        XenosPrintEvenOdd xpe = new XenosPrintEvenOdd(n);
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(xpe::printZero);
        es.submit(xpe::printEven);
        es.submit(xpe::printOdd);
        es.shutdown();
    }
}
