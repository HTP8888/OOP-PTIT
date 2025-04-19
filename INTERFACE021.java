import java.util.*;
import java.util.regex.*;

interface PricedItem {
    double getPrice();
}

interface SourceItem {
    String getSourceName();
}

class OrderFood implements PricedItem, SourceItem {
    private String name;
    private double price;
    private String restaurantName;

    public OrderFood(String name, double price, String restaurantName) {
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
    }

    public String getName() {
        return this.name;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getSourceName() {
        return this.restaurantName;
    }
}

public class INTERFACE021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<OrderFood> orders = new ArrayList<>();
            String line;
            Pattern pattern = Pattern.compile("Dish\\s+\"([^\"]+)\"\\s+(\\d+(?:\\.\\d+)?)\\s+\"([^\"]+)\"");
            while (!(line = sc.nextLine()).equals("Checkout")) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String name = matcher.group(1);
                    double price = Double.parseDouble(matcher.group(2));
                    String restaurant = matcher.group(3);
                    orders.add(new OrderFood(name, price, restaurant));
                }
            }
            String target = sc.nextLine().replaceAll("^\"|\"$", ""); 
            for (OrderFood order : orders) {
                if (order.getSourceName().equals(target)) {
                    System.out.printf("\"%s\" - %.2f\n", order.getName(), order.getPrice());
                }
            }
        }
    }
}
