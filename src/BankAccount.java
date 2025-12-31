public class BankAccount {

    private int balance = 1000;

    public synchronized void withdraw(int amount){
        if(amount <= balance){
            int rembal = balance - amount;
            balance = rembal;
            System.out.println("Amount withdrawn " + amount + " Remaining balance amount " + rembal + " Thread name " + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Insufficient balance ");
        }
    }
}
