public class Main {
    public static void main(String[] args) throws InterruptedException{
        BankAccount bnk = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bnk.withdraw(200);
            }
        };
        Thread th1 = new Thread(runnable, "Thread 1");
        Thread th2 = new Thread(runnable, "Thread 2");
        try{
        th1.join();
        th2.join();
        } catch (InterruptedException e) {
            throw new InterruptedException(e.getMessage());
        }
        th1.start();
        th2.start();
    }
}