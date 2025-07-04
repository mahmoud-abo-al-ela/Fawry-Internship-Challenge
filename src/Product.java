import java.time.LocalDate;

public class Product implements Shippable{
    String name;
    int quantity;
    double price;
    LocalDate expiryDate;
    double weight;

    public Product(String name, int quantity, double price, LocalDate expiryDate, double weight){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
    @Override
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public void reduceQuantity(int amount){
        if (amount > quantity){
            throw new IllegalArgumentException("No enough quantity in stock");
        }
        quantity -= amount;
    }
    public boolean isExpirable(){
        return expiryDate != null;
    }
    public boolean isExpired(){
        return isExpirable() && LocalDate.now().isAfter(expiryDate);
    }
    public boolean isShippable(){
        return weight > 0;
    }
    @Override
    public double getWeight(){
        return weight;
    }
}