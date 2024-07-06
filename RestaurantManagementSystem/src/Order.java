import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private int tableNo;
    private Map<MenuItem,Integer> items;

    public Order(int orderId, int tableNo) {
        this.orderId = orderId;
        this.tableNo = tableNo;
        items = new HashMap<>();
    }
    public void addItem(MenuItem item, int qty){
        items.put(item,qty);
    }
    public void removeItem(MenuItem item){
        items.remove(item);
    }
    public Map<MenuItem, Integer> getItems() {
        return items;
    }
    public double calculateTotal(){
        double total = 0;
        for(Map.Entry<MenuItem,Integer> entry:items.entrySet()){
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
    public int getTableNumber() {
        return tableNo;
    }
    public int getOrderId(){
        return orderId;
    }
}
