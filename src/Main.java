import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese",5,100, LocalDate.of(2025,7,5),200);
        Product biscuits = new Product("Biscuits", 5, 150, LocalDate.of(2025, 12, 31), 700);
        Product tv = new Product("TV", 3, 300, null, 7000);
        Product scratchCard = new Product("Scratch Card", 20, 50, null, 0);
        Customer customer = new Customer("Mahmoud", 2000);
        Cart cart = new Cart();
        cart.add(tv, 3);
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        Checkout.checkout(customer,cart);
    }
}