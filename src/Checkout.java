import java.util.LinkedHashMap;
import java.util.Map;

public class Checkout {
    public static void checkout(Customer customer, Cart cart){
        if (cart.isEmpty()){
            throw new IllegalArgumentException("Cart is empty");
        }
        double subtotal =0;
        double shippingFees =0;
        double totalWeight =0;
        Map<String, ProductSummary> shippingSummary = new LinkedHashMap<>();
        for(Map.Entry<Product,Integer> entry : cart.getItems().entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.reduceQuantity(quantity);
            subtotal += product.getPrice() * quantity;
            if(product.isShippable()){
                double totalProductWeight = product.getWeight() * quantity;
                totalWeight += totalProductWeight;
                ProductSummary summary = shippingSummary.getOrDefault(product.getName(),new ProductSummary(0,0));
                summary.quantity += quantity;
                summary.weight += totalProductWeight;
                shippingSummary.put(product.getName(), summary);
            }
        }
        if(totalWeight>0){
            shippingFees = 30.0;
        }
        double total = subtotal + shippingFees;
        customer.reduceBalance(total);
        if (!shippingSummary.isEmpty()){
            System.out.println("** Shipment notice **");
            for(Map.Entry<String,ProductSummary> entry: shippingSummary.entrySet()){
                ProductSummary summary = entry.getValue();
                System.out.println(summary.quantity + "x " + entry.getKey() + "\t" + (int) summary.weight + "g");
            }
            System.out.printf("Total package weight %.1f kg \n", totalWeight/1000);
        }
        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product,Integer> entry : cart.getItems().entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + "\t" + (int) product.getWeight()+"g");
        }
        System.out.println("----------------------");
        System.out.println("Subtotal \t" + (int) subtotal);
        System.out.println("Shipping \t" + (int) shippingFees);
        System.out.println("Amount   \t" + (int) total);

    }

    private static class ProductSummary {
        double weight;
        int quantity;
        public ProductSummary(double weight,int quantity){
            this.weight = weight;
            this.quantity = quantity;
        }
    }
}
