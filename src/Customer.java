public class Customer{
    String name;
    double balance;
    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void reduceBalance(double amount){
        if (amount > balance){
            throw new IllegalArgumentException("insufficient balance");
        }
        balance -= amount;
    }
}