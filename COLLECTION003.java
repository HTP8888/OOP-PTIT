package COLLECTION;
import java.util.*;

public class COLLECTION003 {
    HashMap<String, Integer> prices;
    HashMap<String, Integer> stocks;

    public COLLECTION003() {
        prices = new HashMap<>();
        stocks = new HashMap<>();
    }

    public void add(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }

    public int price(String product) {
        return prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (stocks.containsKey(product) && stocks.get(product) > 0) {
            stocks.put(product, stocks.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return prices.keySet(); // or stocks.keySet(); both should have the same keys
    }

    public static void main(String[] args) {
        COLLECTION003 wh = new COLLECTION003();
        wh.add("milk", 3, 10);
        wh.add("coffee", 5, 6);
        wh.add("buttermilk", 2, 2);
        wh.add("yogurt", 2, 20);
        wh.take("buttermilk");
        wh.take("milk");
        wh.take("buttermilk");
        for (String product : wh.products()) {
            if (wh.stock(product) > 0) {
                System.out.println(product);
            }
        }
    }
}
