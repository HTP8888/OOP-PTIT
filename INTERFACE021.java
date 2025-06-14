import java.util.ArrayList;
import java.util.Scanner;

interface PricedItem {
    double getPrice();
}

interface SourceableItem {
    String getSourceName();
}

class Dish implements PricedItem, SourceableItem {
    String name;
    double price;
    String restaurantName;

    public Dish(String name, double price, String restaurantName) {
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
    }

    public double getPrice() {
        return this.price;
    }

    public String getSourceName() {
        return this.restaurantName;
    }

    public String toString() {
        return String.format("\"%s\" - %.2f", name, price);
    }
}

public class Main {
    public static String[] tach(String s) {
        // Split by quotes and filter out empty strings
        String[] parts = s.split("\"");
        ArrayList<String> result = new ArrayList<>();
        
        for (String part : parts) {
            part = part.trim();
            if (!part.isEmpty()) {
                result.add(part);
            }
        }
        
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;

        while (t-- > 0) {
            ArrayList<Dish> arr = new ArrayList<>();
            
            while (true) {
                String in = sc.nextLine();
                if (in.equals("Checkout")) break;
                
                String[] parts = tach(in);
                // Expected format: Dish "Dish Name" price "Restaurant Name" 
                // After splitting: [Dish , Dish Name, price, Restaurant Name]
                
                if (parts.length >= 4) {
                    String dishName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String restaurantName = parts[3];
                    
                    Dish d = new Dish(dishName, price, restaurantName);
                    arr.add(d);
                }
            }
            
            String checkLine = sc.nextLine();
            String[] checkParts = tach(checkLine);
            String targetRestaurant = checkParts[0]; // The restaurant name to filter by
            
            for (Dish tmp : arr) {
                if (tmp.getSourceName().equals(targetRestaurant)) {
                    System.out.println(tmp);
                }
            }
        }
        sc.close();
    }
}
