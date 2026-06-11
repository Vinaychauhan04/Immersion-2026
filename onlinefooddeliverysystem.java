class FoodItem {

    // Data Members
    private int    itemId;
    private String itemName;
    private double price;
    private int    quantity;

    // Constructor
    public FoodItem(int itemId, String itemName, double price, int quantity) {
        this.itemId    = itemId;
        this.itemName  = itemName;
        this.price     = price;
        this.quantity  = quantity;
    }

    // Method: calculateAmount()
    public double calculateAmount() {
        return price * quantity;
    }

    // Method: displayItemDetails()
    public void displayItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + (int) price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Amount    : " + (int) calculateAmount());
    }

    // Getters (for use in main logic)
    public String getItemName() { return itemName; }
    public double getPrice()    { return price; }
    public int    getQuantity() { return quantity; }
}


// ─── Class 2: Customer ───────────────────────────────────────
class Customer {

    // Data Members
    private int    customerId;
    private String customerName;
    private String mobileNumber;

    // Constructor
    public Customer(int customerId, String customerName, String mobileNumber) {
        this.customerId    = customerId;
        this.customerName  = customerName;
        this.mobileNumber  = mobileNumber;
    }

    // Method: displayCustomerDetails()
    public void displayCustomerDetails() {
        System.out.println("Customer ID     : " + customerId);
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Mobile Number   : " + mobileNumber);
    }

    // Getter
    public String getCustomerName() { return customerName; }
}


// ─── Main Class ──────────────────────────────────────────────
public class onlinefooddeliverysystem {

    // Helper: print a divider line
    static void line() {
        System.out.println("-----------------------");
    }

    // Helper: print order summary for one customer + their items
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

        // ── Create 2 Customer objects ────────────────────────
        Customer customer1 = new Customer(101, "Rahul Sharma", "9876543210");
        Customer customer2 = new Customer(102, "Priya Singh",  "9123456789");

        // ── Create FoodItem objects for Customer 1 (4 items) ─
        FoodItem item1 = new FoodItem(1, "Burger",       120,  2);
        FoodItem item2 = new FoodItem(2, "Pizza",        300,  1);
        FoodItem item3 = new FoodItem(3, "French Fries",  80,  3);
        FoodItem item4 = new FoodItem(4, "Cold Drink",    50,  2);

        // ── Create FoodItem objects for Customer 2 (2 items) ─
        FoodItem item5 = new FoodItem(5, "Pasta",        200,  1);
        FoodItem item6 = new FoodItem(6, "Garlic Bread",  90,  2);

        // ── Group items per customer ─────────────────────────
        FoodItem[] order1 = { item1, item2, item3, item4 };
        FoodItem[] order2 = { item5, item6 };

        // ── Print full order summaries ───────────────────────
        printOrderSummary(customer1, order1);
        printOrderSummary(customer2, order2);
    }
}
