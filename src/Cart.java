import java.util.HashMap;
import java.util.Map;

public class Cart{
    Map<Product,Integer> items = new HashMap<>();

    public void add(Product product, int quantity){
        int currentQty = items.getOrDefault(product,0);
        if (product.isExpired()){
            throw new IllegalArgumentException("Product Expired: "+ product.getName());
        }
        if (quantity <= 0){
            throw new IllegalArgumentException("quantity cannot be negative in: " + product.getName());
        }
        if (currentQty + quantity > product.getQuantity()){
            throw new IllegalArgumentException("No enough quantity in stock for: " + product.getName());
        }
        items.put(product, currentQty+quantity);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public Map<Product,Integer> getItems(){
        return items;
    }
}
