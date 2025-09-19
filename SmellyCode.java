// God Class
public class OrderProcessor {
    private List<Product> products;
    private Customer customer;
    private double totalAmount;

    public OrderProcessor(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        this.totalAmount = 0;
    }

    // Long Method
    public void processOrder(String paymentMethod, String shippingAddress, boolean applyDiscount) {
        // Step 1: Calculate total amount
        for (Product product : products) {
            this.totalAmount += product.getPrice() * product.getQuantity();
        }

        // Step 2: Apply discount (Feature Envy)
        if (applyDiscount && customer.isPremium()) {
            // This logic should be in the Customer class, but it's "envious" of Customer's data
            double discountRate = customer.getDiscountRate();
            this.totalAmount *= (1 - discountRate);
        }

        // Step 3: Handle payment (Switch Statement)
        // This is a common place for a switch statement smell.
        double transactionFee = 0;
        switch (paymentMethod) {
            case "CreditCard":
                transactionFee = this.totalAmount * 0.02;
                // Payment gateway integration logic...
                System.out.println("Processing credit card payment...");
                break;
            case "PayPal":
                transactionFee = this.totalAmount * 0.015;
                // PayPal API integration logic...
                System.out.println("Processing PayPal payment...");
                break;
            case "BankTransfer":
                transactionFee = 5.0; // Flat fee
                // Bank transfer logic...
                System.out.println("Processing bank transfer...");
                break;
            default:
                throw new IllegalArgumentException("Invalid payment method.");
        }
        this.totalAmount += transactionFee;

        // Step 4: Update stock
        for (Product product : products) {
            product.updateStock();
        }

        // Step 5: Generate shipping label
        String shippingLabel = "Ship to: " + shippingAddress + " for order #" + customer.getCustomerId();
        System.out.println("Generating shipping label: " + shippingLabel);

        // Step 6: Send confirmation email
        System.out.println("Sending confirmation email to " + customer.getEmail() + " for a total of " + this.totalAmount);
    }
}

// Data Class
// This class holds data but lacks behavior.
// It's just a container for data.
class Product {
    private String name;
    private double price;
    private int quantity;
    private String sku;

    public Product(String name, double price, int quantity, String sku) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
    }

    // Getters and setters...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    // Method to illustrate the data class issue, but it's minimal behavior
    public void updateStock() {
        this.quantity--;
    }
}

// Another Data Class, used by the God Class
class Customer {
    private int customerId;
    private String name;
    private String email;
    private boolean isPremium;

    public Customer(int customerId, String name, String email, boolean isPremium) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.isPremium = isPremium;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isPremium() {
        return isPremium;
    }

    // This method is envied by the OrderProcessor
    public double getDiscountRate() {
        return 0.1; // 10% for premium customers
    }
}
