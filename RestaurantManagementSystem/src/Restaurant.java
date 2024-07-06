import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private Map<Integer,Table> tables;
    private Menu menu;
    private Map<Integer, Order> orders;
    private int nextOrderId;

    public Restaurant(){
        tables = new HashMap<>();
        menu = new Menu();
        orders = new HashMap<>();
        nextOrderId = 1;
    }

    public void addtable(int tableNo){
        tables.put(tableNo,new Table(tableNo,false));
    }
    public void removeTable(int tableNo){
        tables.remove(tableNo);
    }
    public void addMenuItem(MenuItem item){
        menu.addItem(item);
    }
    public void removeMenuItem(MenuItem item){
        menu.removeItem(item.getId());
    }
    public void placeOrder(int tableNo,Map<MenuItem,Integer> orderedItems){
        Order order = new Order(nextOrderId++,tableNo);
        orderedItems.forEach(order::addItem);
        orders.put(order.getOrderId(),order);
    }
    public double calculateBillWithCharges(Order order,PaymentType paymentType){
        double totalAmount = order.calculateTotal();
        // Calculate taxes (assumed 10% for demonstration)
        double taxRate = 0.1;
        double taxAmount = totalAmount * taxRate;

        // Additional charges based on payment type
        double additionalCharges = 0;
        switch (paymentType) {
            case CASH:
                additionalCharges = 0; // No additional charges for cash payments
                break;
            case CREDIT_CARD:
                additionalCharges = totalAmount * 0.01; // 1% processing fee for credit card
                break;
            case UPI:
                additionalCharges = 5; // Flat fee for UPI payments
                break;
            default:
                break;
        }
        // Calculate total bill including taxes and charges
        double finalAmount = totalAmount + taxAmount + additionalCharges;

        return finalAmount;
    }
    public void printBill(int orderId, PaymentType paymentType){
        Order order = orders.get(orderId);
        if(order != null){
            double totalAmount = order.calculateTotal();
            double taxRate = 0.1; // 10% tax rate assumed
            double taxAmount = totalAmount * taxRate;

            double additionalCharges = 0;
            switch (paymentType) {
                case CASH:
                    additionalCharges = 0; // No additional charges for cash payments
                    break;
                case CREDIT_CARD:
                    additionalCharges = totalAmount * 0.01; // 1% processing fee for credit card
                    break;
                case UPI:
                    additionalCharges = 5; // Flat fee for UPI payments
                    break;
                default:
                    break;
            }
            double finalAmount = totalAmount + taxAmount + additionalCharges;

            // Print bill details
            System.out.println("Bill for Order ID: " + order.getOrderId());
            System.out.println("Table Number: " + order.getTableNumber());
            System.out.println("Items:");

            for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
                MenuItem item = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("- " + item.getName() + " x" + quantity + ": " + item.getPrice() * quantity);
            }

            System.out.println("Total Amount: " + totalAmount);
            System.out.println("Tax (10%): " + taxAmount);
            System.out.println("Additional Charges: " + additionalCharges);
            System.out.println("Final Amount: " + finalAmount);
        }
    }


}
