package COLLECTION;
import java.util.*;
public class COLLECTION002 {
    final HashMap<String, Integer>prices;
    final HashMap<String, Integer>stocks;
    public COLLECTION002(){
        prices = new HashMap<>();
        stocks = new HashMap<>();
    }
    public void add(String product, int price, int stock){
        prices.put(product, price);
        stocks.put(product, stock);
    }
    public int getPrice(String product){
        return prices.getOrDefault(product, -99);
    }
    public int getStock(String product){
        return stocks.getOrDefault(product, 0);
    }
    public boolean take(String product){
        if(stocks.containsKey(product)&&stocks.get(product)> 0){
            stocks.put(product, stocks.get(product) - 1);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        COLLECTION002 wh = new COLLECTION002();
        wh.add("coffee",5,1);
        System.out.println("stock:");
        System.out.println("coffee: "+wh.getStock("coffee"));
        System.out.println("sugar: "+wh.getStock("sugar"));
        System.out.println("taking coffee "+wh.take("coffee"));
        System.out.println("taking coffee" +wh.take("coffee"));
        System.out.println("taking sugar "+wh.take("sugar"));
        System.out.println("stock:");
        System.out.println("coffee: "+wh.getStock("coffee"));
        System.out.println("sugar: "+wh.getStock("sugar"));
    }
}
