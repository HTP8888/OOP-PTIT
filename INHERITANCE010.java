/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.*;
/**
 *
 * @author 503
 */
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
    public abstract double calculateCost(int quantity);
    public abstract void displayDetails();
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
}

class Book extends Product {
    private String author;
    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
    @Override
    public double calculateCost(int quantity) {
        return price * quantity;
    }
    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("Author: " + author);
    }
}

class Electronics extends Product {
    private String brand;
    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }
    @Override
    public double calculateCost(int quantity) {
        return price * quantity * 1.1;
    }
    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("Brand: " + brand);
    }
}
class User {
    private String username;
    private double totalSpent;
    public User(String username) {
        this.username = username;
        this.totalSpent = 0.0;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
    public String getUsername() {
        return username;
    }
    public void buyProduct(Product product, int quantity) {
        if (quantity <= product.getQuantity()) {
            double total = product.calculateCost(quantity);
            totalSpent += total;
            product.reduceQuantity(quantity);
            System.out.println("User: " + username + " bought " + quantity + " " + product.getName() + " for $" + total);
        } else {
            System.out.println("Insufficient quantity of " + product.getName() + " available.");
        }
    }
}

public class INHERITANCE010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            Product laptop = new Electronics("laptop", 20.0, 10, "Dell");
            Product book = new Book("Harry Potter", 10.0, 12, "camnh");
            User user1 = new User("Alice");
            User user2 = new User("Bob");
            User user3 = new User("Charlie");
            user1.buyProduct(laptop, 3);
            user1.buyProduct(book, 10);
            user2.buyProduct(laptop, 1);
            user3.buyProduct(book, 5);
            System.out.println("====");
            User[] users = {user1, user2, user3};
            for (int i = 0; i < users.length - 1; i++) {
                for (int j = i + 1; j < users.length; j++) {
                    if (users[i].getTotalSpent() < users[j].getTotalSpent()) {
                        User temp = users[i];
                        users[i] = users[j];
                        users[j] = temp;
                    }
                }
            }
            System.out.println("Users with Highest Total Spent:");
            for (int i = 0; i < users.length; i++) {
                System.out.printf("%d. %s: $%.1f\n", i + 1, users[i].getUsername(), users[i].getTotalSpent());
            }
            System.out.println("====");
            laptop.displayDetails();
            System.out.println("---");
            book.displayDetails();
        }

        sc.close();
    }
}