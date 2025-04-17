import java.util.*;

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    abstract double caculateCost(int quantity);

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void reduceQuantity(int amount) {
        quantity -= amount;
    }
    public String displayDetails() {
        return "Name: " + name + "\nPrice: $" + price + "\nAvailable Quantity: " + quantity;
    }
}
class Book extends Product {
    private final String author;
    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
    @Override
    double caculateCost(int quantity) {
        return price * quantity;
    }
    @Override
    public String displayDetails() {
        return super.displayDetails() + "\nAuthor: " + author;
    }
}
class Electronics extends Product {
    private final String brand;
    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }
    @Override
    double caculateCost(int quantity) {
        return price * quantity * 1.1;
    }
    @Override
    public String displayDetails() {
        return super.displayDetails() + "\nBrand: " + brand;
    }
}
class User {
    private final String username;
    private double totalSpent;

    public User(String username) {
        this.username = username;
        this.totalSpent = 0;
    }
    public String getUsername() {
        return username;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
    public void buyProduct(Product product, int qty) {
        if (qty <= product.getQuantity()) {
            double cost = product.caculateCost(qty);
            totalSpent += cost;
            product.reduceQuantity(qty);
            System.out.println("User: " + username + " bought " + qty + " " + product.getName() + " for $" + cost);
        } else {
            System.out.println("Insufficient quantity of " + product.getName() + " available.");
        }
    }
}
public class INHERITANCE010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Electronics laptop = new Electronics("laptop", 20, 10, "Dell");
            Book harryPotter = new Book("Harry Potter", 10, 12, "camnh");
            User user1 = new User("Alice");
            User user2 = new User("Bob");
            User user3 = new User("Charlie");
            user1.buyProduct(laptop, 3);
            user1.buyProduct(harryPotter, 10);
            user2.buyProduct(laptop, 1);
            user3.buyProduct(harryPotter, 5);
            System.out.println("====");
            System.out.println("Users with Highest Total Spent:");
            User[] users = { user1, user2, user3 };
            for (int i = 0; i < users.length - 1; i++) {
                for (int j = i + 1; j < users.length; j++) {
                    if (users[i].getTotalSpent() < users[j].getTotalSpent()) {
                        User tmp = users[i];
                        users[i] = users[j];
                        users[j] = tmp;
                    }
                }
            }
            for (int i = 0; i < users.length; i++) {
                System.out.println((i + 1) + ". " + users[i].getUsername() + ": $" + users[i].getTotalSpent());
            }
            System.out.println("====");
            System.out.println(laptop.displayDetails());
            System.out.println("---");
            System.out.println(harryPotter.displayDetails());
        }
    }
}
