public class XenosPrintEvenOdd {

    private boolean printZero = true;
    private int n = -1;
    private int count = 1;
    XenosPrintEvenOdd(int n){
     this.n =  n;
    }
     public synchronized void printZero() {
         while (count <= n) {
             while (!printZero) {
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     System.out.println(e.getMessage());
                 }
             }
             if(count > n) break;
             System.out.println(Thread.currentThread().getName() + " " + 0 + " ");
             printZero = false;
             notifyAll();
         }
     }
    public synchronized void printEven() {
        while (count <= n) {
            while (count % 2 != 0 || printZero) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + count + " ");
            if(count > n) break;
            printZero = true;
            count++;
            notifyAll();
        }
    }
    public synchronized void printOdd() {
        while (count <= n) {
            while (count % 2 == 0 || printZero) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + count + " ");
            printZero = true;
            count++;
            notifyAll();
        }
    }
}
