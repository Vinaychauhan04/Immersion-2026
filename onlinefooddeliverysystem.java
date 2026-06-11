class FoodItem {

    
    private int    itemId;
    private String itemName;
    private double price;
    private int    quantity;

    
    public FoodItem(int itemId, String itemName, double price, int quantity) {
        this.itemId    = itemId;
        this.itemName  = itemName;
        this.price     = price;
        this.quantity  = quantity;
    }

    
    public double calculateAmount() {
        return price * quantity;
    }

    
    public void displayItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + (int) price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Amount    : " + (int) calculateAmount());
    }

    
    public String getItemName() { return itemName; }
    public double getPrice()    { return price; }
    public int    getQuantity() { return quantity; }
}



class Customer {

    
    private int    customerId;
    private String customerName;
    private String mobileNumber;

    
    public Customer(int customerId, String customerName, String mobileNumber) {
        this.customerId    = customerId;
        this.customerName  = customerName;
        this.mobileNumber  = mobileNumber;
    }

    
    public void displayCustomerDetails() {
        System.out.println("Customer ID     : " + customerId);
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Mobile Number   : " + mobileNumber);
    }

    
    public String getCustomerName() { return customerName; }
}



public class onlinefooddeliverysystem {

    
    static void line() {
        System.out.println("-----------------------");
    }

    
    static void printOrderSummary(Customer customer, FoodItem[] items) {
        System.out.println("=========================================");
        System.out.println("           ORDER SUMMARY");
        System.out.println("=========================================");

        customer.displayCustomerDetails();
        line();

        double totalBill = 0;

        for (FoodItem item : items) {
            item.displayItemDetails();
            totalBill += item.calculateAmount();
            line();
        }

        System.out.println("Total Bill: " + (int) totalBill);
        line();
        System.out.println();
    }

    public static void main(String[] args) {

        
        Customer customer1 = new Customer(101, "Rahul Sharma", "9876543210");
        Customer customer2 = new Customer(102, "Priya Singh",  "9123456789");

        
        FoodItem item1 = new FoodItem(1, "Burger",       120,  2);
        FoodItem item2 = new FoodItem(2, "Pizza",        300,  1);
        FoodItem item3 = new FoodItem(3, "French Fries",  80,  3);
        FoodItem item4 = new FoodItem(4, "Cold Drink",    50,  2);

        
        FoodItem item5 = new FoodItem(5, "Pasta",        200,  1);
        FoodItem item6 = new FoodItem(6, "Garlic Bread",  90,  2);

        
        FoodItem[] order1 = { item1, item2, item3, item4 };
        FoodItem[] order2 = { item5, item6 };

        
        printOrderSummary(customer1, order1);
        printOrderSummary(customer2, order2);
    }
}
